
CREATE OR REPLACE PROCEDURE p_auclist(
    p_mem_id mem.mem_id%TYPE,
    p_auccur out sys_refcursor
)
IS
BEGIN
    open p_auccur for select a.auc_detail, a.auc_price, a.auc_closeprice, a.auc_stat, a.auc_seqno,
                        (select (select thumb_filename from att_thumb at where at.att_seqno = a.att_seqno) from att a where a.item_seqno = i.item_seqno) thumb_filename
                        from item i, (select item_seqno, auc_detail, auc_price, auc_closeprice, auc_stat, auc_seqno from auc a) a
                        where i.item_seqno = a.item_seqno
                        and mem_id = 'ccc';
END;
/

create or replace NONEDITIONABLE PROCEDURE p_prolist(
    p_item_mem_id    in item.mem_id%type,
     p_cur    out sys_refcursor
    
)
IS         
BEGIN
    open p_cur for
                select (select item_name from item i where i.item_seqno = p.item_seqno) item_naem,
                (select item_detail from item i where i.item_seqno = p.item_seqno) item_detail,
                (select (select thumb_filename from att_thumb at where at.att_seqno = a.att_seqno) from att a where a.item_seqno = p.item_seqno) thumb_filename,
                p.pro_amount,p.pro_saleprice, p.pro_seqno
                from pro p
                where mem_id = p_item_mem_id
                and pro_stat not in 'PRO_END';                 
END;
/


create or replace NONEDITIONABLE PROCEDURE p_salesHistory(
    p_mem_id in mem.mem_id%type,
    p_sale_cur   out SYS_REFCURSOR,
    p_month      out sys_refcursor,
    p_year       out sys_refcursor
)
is
begin
    open p_sale_cur FOR
    select distinct rownum,total,orderdetail_stat, item_name,item_img,pro_opendate,pro_stat from	 
            (select (select item_name from item i where i.item_seqno = p.item_seqno) as item_name, 
            (select item_img from item i where i.item_seqno = p.item_seqno) as item_img, 
            (select mem_id from item i where i.item_seqno = p.item_seqno) as mem_id, 
            pro_opendate,orderdetail_stat,(p.pro_price * amount) as total, pro_stat 
            from pro p , 
            (select pro_seqno, mo.amount, orderdetail_stat from  
            (select od.orderdetail_stat,o.order_seqno from orderdetail od , orders o 
            where od.order_seqno = o.order_seqno) o, 
            (select pro_seqno,order_seqno,amount from mini_order) mo 
            where o.order_seqno = mo.order_seqno) o 
            where p.pro_seqno = o.pro_seqno order by pro_opendate desc) where mem_id = p_mem_id;

end;
/

CREATE OR REPLACE PROCEDURE p_calculate(
    p_id    mem.mem_id%TYPE,
    p_mcur  out sys_refcursor,
    p_ycur  out sys_refcursor
)
IS
BEGIN
    open p_mcur for select distinct sum(order_totalprice) over(partition by salemonth) total, count(salemonth) over(partition by salemonth) count, salemonth
                    from
                    (
                    select to_char(order_date, 'YYYY-MM') salemonth, 
                    order_totalprice,(select (select mem_id from item i where i.item_seqno = p.item_seqno) 
                                        from pro p where p.pro_seqno = mo.pro_seqno) mem_id
                    from orders o, mini_order mo
                    where o.order_seqno = mo.order_seqno
                    ) a
                    where mem_id = p_id;
                    
                    
    open p_ycur for select distinct sum(order_totalprice) over(partition by salemonth) total, count(salemonth) over(partition by salemonth) count, salemonth
                    from
                    (
                    select to_char(order_date, 'YYYY') salemonth, 
                    order_totalprice,(select (select mem_id from item i where i.item_seqno = p.item_seqno) 
                                        from pro p where p.pro_seqno = mo.pro_seqno) mem_id
                    from orders o, mini_order mo
                    where o.order_seqno = mo.order_seqno
                    ) a
                    where mem_id = p_id;
END;
/

CREATE OR REPLACE PROCEDURE p_prodelete(
    p_seqno     pro.pro_seqno%TYPE,
    p_attcur    out sys_refcursor
)
IS
    v_attseqno att.att_seqno%TYPE;
    v_i_seqno item.item_seqno%TYPE;
BEGIN
    open p_attcur for select (select att_savename from att a where a.item_seqno = i.item_seqno) att_savename,
                        (select att_path from att a where a.item_seqno = i.item_seqno) att_path,
                        (select (select thumb_filename from att_thumb at where a.att_seqno = at.att_seqno) from att a where a.item_seqno = i.item_seqno) thumb_savename,
                        (select (select thumb_filepath from att_thumb at where a.att_seqno = at.att_seqno) from att a where a.item_seqno = i.item_seqno) thumb_path
                        from pro p,item i
                        where p.item_seqno = i.item_seqno
                        and pro_seqno = p_seqno;
                        
    select (select att_seqno from att a where a.item_seqno = i.item_seqno) att_seqno,
    p.item_seqno as i_seqno into v_attseqno, v_i_seqno
    from pro p, item i
    where p.item_seqno = i.item_seqno
    and pro_seqno = p_seqno;
    
    IF SQL%FOUND THEN
            IF v_attseqno is not null THEN
                DELETE FROM att_thumb WHERE att_seqno = v_attseqno;
            END IF;
            DELETE FROM att WHERE att_seqno = v_attseqno;
    END IF;
    
    delete cart where pro_seqno = p_seqno;
    delete pro where pro_seqno = p_seqno;
    delete item where item_seqno = v_i_seqno;
    
    
END;