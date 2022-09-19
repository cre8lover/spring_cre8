
--���ν��� AUC����Ʈ �˻����(������)
CREATE OR REPLACE PROCEDURE aucList(
    p_search IN VARCHAR2,
    p_current_page IN INTEGER,
    p_row_per_page IN INTEGER,
    v_board_cur OUT SYS_REFCURSOR,
    v_total OUT INTEGER
)
IS
    v_rownum INTEGER := p_current_page * p_row_per_page;
    v_rn    INTEGER := (p_current_page-1) * p_row_per_page;
    v_sql VARCHAR2(5000);
    curid NUMBER;
    ret     NUMBER;
    TYPE board_rs IS RECORD (
        seqno item.item_seqno%TYPE
    );
    v_board board_rs;

BEGIN
    v_sql := 'select *
                from (
                select rownum rn, item_seqno, item_img, item_name, auc_detail, auc_price, auc_closeprice, auc_seqno, auc_hits, sdate, fdate, minusday
                from  ( select i.item_seqno as item_seqno, i.item_name as item_name, a.auc_detail as auc_detail, a.auc_price as auc_price,
                a.auc_closeprice as auc_closeprice, a.auc_seqno as auc_seqno, 
                a.auc_hits as auc_hits, to_char(a.auc_start, ''YYYY-MM-DD,HH24:MI:SS'') as sdate, to_char(a.auc_finish, ''YYYY-MM-DD,HH24:MI:SS'') as fdate,
                (select (select thumb_filename from att_thumb at where at.att_seqno = z.att_seqno) from att z where z.item_seqno = i.item_seqno) as item_img,
                (to_date(a.auc_finish, ''YYYY-MM-DD,HH24:MI:SS'')-to_date(sysdate, ''YYYY-MM-DD,HH24:MI:SS'')) as minusday
                from item i, auc a where i.item_seqno = a.item_seqno and auc_stat in ''AUC_ING'')
                WHERE rownum <= ' || v_rownum ; 
                IF p_search IS NOT NULL THEN v_sql := v_sql || ' order by '|| p_search ||' desc '; END IF;
                v_sql := v_sql || ' )
                WHERE rn >' || v_rn ;
                
    --Ŀ�� ����
    curid := DBMS_SQL.OPEN_CURSOR;
    --SQL �Ľ�
    DBMS_SQL.PARSE(curid, v_sql, DBMS_SQL.NATIVE);
    
    --���ε� ����
    
--    IF p_search IS NOT NULL THEN DBMS_SQL.BIND_VARIABLE(curid, ':1', p_search); END IF;
--    DBMS_OUTPUT.PUT_LINE(p_search);
    --SQL������
    ret := DBMS_SQL.EXECUTE(curid);
    
    --Ŀ�� id�� �̿��ؼ� Ŀ�� ������ ����
    v_board_cur := DBMS_SQL.TO_REFCURSOR(curid);
    
    select count(*) into v_total from auc where auc_stat in 'AUC_ING';
--    LOOP
--        FETCH v_board_cur INTO v_board;
--        EXIT WHEN v_board_cur%NOTFOUND;
--        DBMS_OUTPUT.PUT_LINE(v_board.seqno);
--    END LOOP;
--    CLOSE v_board_cur;
END;

/


DECLARE
    v_rs_cur SYS_REFCURSOR; --OPEN, CLOSE �������� ��Ʈ��Ŀ��
    
    TYPE v_board_rec IS RECORD(
        rn NUMBER,
        itemseqno item.item_seqno%TYPE,
        itemimg att.att_name%TYPE,
        itemname item.item_name%TYPE,
        aucdetail auc.auc_detail%TYPE,
        aucprice auc.auc_price%TYPE,
        auccloseprice auc.auc_closeprice%TYPE,
        aucseqno auc.auc_seqno%TYPE,
        auchits auc.auc_hits%TYPE,
        aucstart VARCHAR(200),
        aucfinish VARCHAR(200),
        aucdday number
    );
    v_count number;
    v_board v_board_rec;
BEGIN
    aucList('auc_hits', 1, 10, v_rs_cur,v_count);
--    OPEN v_board_cur;
    DBMS_OUTPUT.PUT_LINE(v_count);
     LOOP
        FETCH v_rs_cur INTO v_board;
        EXIT WHEN v_rs_cur%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_board.itemimg || ',' || v_board.aucdday || ',' || v_board.aucdetail);
    END LOOP;
--    CLOSE v_board_cur;
END;

/


--���� ������
create or replace procedure p_auc_detail(
    p_auc_seqno in auc.auc_seqno%TYPE,
    p_auc_cur out SYS_REFCURSOR,
    p_auc_price out SYS_REFCURSOR
)
is
begin
    open p_auc_cur for select i.item_seqno as item_seqno, i.item_name as item_name, 
            (select att_savename from att at where at.item_seqno = i.item_seqno) item_img,
             y.auc_seqno as auc_seqno, y.auc_img as auc_img, y.auc_shortdetail as auc_shortdetail,
            y.auc_price as auc_price, to_char(y.auc_finish, 'YYYY-MM-DD,HH24:MI:SS') as auc_finish, y.aucCloseprice as aucCloseprice,
            y.auc_count as auc_count, i.mem_id as mem_id, i.item_detail as item_detail
            from item i,
            (select a.item_seqno, a.auc_seqno,a.auc_shortdetail,
            a.auc_price, a.auc_finish, a.auc_start, auc_img as auc_img,
            (select max(an.aucnow_lastprice) from auc_nowing an where a.auc_seqno=an.auc_seqno) as aucCloseprice,
            (select count(an.aucnow_seqno) as auc_count from auc_nowing an where a.auc_seqno = an.auc_seqno) as auc_count
            from auc a) y
            where y.item_seqno = i.item_seqno
            and y.auc_seqno = p_auc_seqno; 
            
    
      OPEN p_auc_price FOR select m.mem_name as mem_name, an.aucnow_date as aucnow_date, an.aucnow_lastprice as aucnow_lastprice, m.mem_id as mem_id 
                from auc_nowing an ,  mem m
                where m.mem_id = an.mem_id
                and an.auc_seqno = p_auc_seqno
               order by an.aucnow_lastprice desc;
end;

declare
    c_auc_detailcur SYS_REFCURSOR;
    c_auc_nowcur SYS_REFCURSOR;
    type p_auc_rec is record(
        item_seqno item.item_seqno%TYPE,
        item_name  item.item_name%TYPE,
        item_img   att.att_savename%TYPE,
        auc_seqno  auc.auc_seqno%TYPE,
        auc_img    auc.auc_img%TYPE,
auc_shortdetail    auc.auc_shortdetail%TYPE,
        auc_price  auc.auc_price%TYPE,
        auc_finish varchar2(200),
    aucCloseprice  auc_nowing.aucnow_lastprice%TYPE,
        auc_count  INTEGER,
        mem_id     mem.mem_id%TYPE,
    item_detail    item.item_detail%TYPE
    );
    type p_auc_nowrec is record(
        mem_name        mem.mem_name%TYPE,
        aucnow_date     auc_nowing.aucnow_date%TYPE,
        aucnow_lastprice auc_nowing.aucnow_lastprice%TYPE,
        mem_id          mem.mem_id%TYPE
    );
    p_detail p_auc_rec;
    p_aucnow p_auc_nowrec;
begin
    p_auc_detail(2,c_auc_detailcur,c_auc_nowcur);
    LOOP
    FETCH c_auc_detailcur into p_detail;
    EXIT WHEN c_auc_detailcur%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(p_detail.item_name);
    END LOOP;
    LOOP
    FETCH c_auc_nowcur into p_aucnow;
    EXIT WHEN c_auc_nowcur%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(p_aucnow.mem_name);
    END LOOP;
end;


/


--�Խñ� ���� ���ν���

CREATE OR REPLACE PROCEDURE p_pro_add(
    p_item_deatile   IN item.item_detail%TYPE,
    p_item_name      IN item.item_name%TYPE,
    p_mem_id         IN mem.mem_id%TYPE,
    p_pro_price      IN pro.pro_price%TYPE,
    p_pro_hits       IN pro.pro_hits%TYPE,
    p_pro_saleprice  IN pro.pro_saleprice%TYPE,
    p_pro_opendate   IN pro.pro_opendate%TYPE,
    p_pro_closedate  IN pro.pro_closedate%TYPE,
    p_pro_detail     IN pro.pro_detail%TYPE,
    p_pro_amount     IN pro.pro_amount%TYPE,
    p_pro_stat       in pro.pro_stat%TYPE,
    p_att_name       in att.att_name%TYPE,
    p_att_savename   in att.att_savename%TYPE,
    p_att_size       in att.att_size%TYPE,
    p_att_type       in att.att_type%TYPE,
    p_att_path       in att.att_path%TYPE,
    p_attth_name     in att_thumb.thumb_filename%TYPE,
    p_attth_size     in att_thumb.thumb_filesize%TYPE,
    p_attth_path     in att_thumb.thumb_filepath%TYPE,
    p_pro_seqno      OUT pro.pro_seqno%TYPE
)IS
    v_item_seqno item.item_seqno%TYPE;
    v_pro_seqno pro.pro_seqno%TYPE;
    v_att_seqno att.att_seqno%TYPE;
BEGIN
    v_item_seqno := item_seqno.nextval;
    v_pro_seqno :=  pro_seqno.nextval;
    v_att_seqno :=  att_seqno.nextval;
    
    insert into item(item_seqno,item_detail,item_name,mem_id) values(v_item_seqno,p_item_deatile,p_item_name,p_mem_id);
    

    insert into pro(pro_seqno, pro_price, cat_seqno, pro_saleprice, pro_opendate, pro_closedate, pro_detail, mem_id, item_seqno, pro_amount, pro_stat)
            values (v_pro_seqno, p_pro_price, p_pro_hits, p_pro_saleprice, p_pro_opendate, p_pro_closedate, p_pro_detail, p_mem_id, v_item_seqno, p_pro_amount ,p_pro_stat);

    
    insert into att(att_seqno, item_seqno, att_name, att_savename, att_size, att_type, att_path)
                values(v_att_seqno, v_item_seqno, p_att_name, p_att_savename, p_att_size, p_att_type, p_att_path);
                
    
    insert into att_thumb(thumb_seqno, thumb_filename, thumb_filesize, thumb_filepath, att_seqno)
                values (thumb_seqno.nextval, p_attth_name, p_attth_size, p_attth_path, v_att_seqno);
    
    p_pro_seqno := v_pro_seqno;

END;

DECLARE
    PRO_SEQNO PRO.PRO_SEQNO%TYPE;
BEGIN
    p_pro_add('��ȫ��','��ȫ��','ccc',200,1,200,'2022/08/31','2022/09/30','��ȫ��',
    1,'PRO_ING','����.jpg','����-1.jpg',
    500,'IMAGE','d:/jmh/upload/',
    '����_thumb.jpg',200,'d:/jmh/upload/thumb/',PRO_SEQNO);
    dbms_output.put_line(PRO_SEQNO);
END;











--�׽�Ʈ ���ν���
desc ATT_THUMB;
CREATE OR REPLACE TYPE obj_thumb IS OBJECT(
    p_attth_name     VARCHAR2(2000),
    p_attth_size     VARCHAR2(50),
    p_attth_path     VARCHAR2(50)
);

CREATE OR REPLACE TYPE obj_att IS OBJECT(
    p_att_name       VARCHAR2(500),
    p_att_savename   VARCHAR2(1000),
    p_att_size       VARCHAR2(50),
    p_att_type       VARCHAR2(50),
    p_att_path       VARCHAR2(100),
    p_att_thumb      obj_thumb
);
CREATE OR REPLACE TYPE obj_pro IS OBJECT(
    p_item_deatile   VARCHAR2(50),
    p_item_name      VARCHAR2(500),
    p_mem_id         VARCHAR2(50),
    p_pro_price      NUMBER,
    p_pro_hits       NUMBER,
    p_pro_saleprice  NUMBER,
    p_pro_opendate   varchar2(500),
    p_pro_closedate  varchar2(500),
    p_pro_detail     VARCHAR2(1000),
    p_pro_amount     NUMBER,
    p_pro_stat       VARCHAR2(50),
    p_pro_seqno      NUMBER,
    att              obj_att
);

CREATE OR REPLACE PROCEDURE p_pro_add_test(
    p_prolit        obj_pro,
    p_pro_seqno      OUT pro.pro_seqno%TYPE
)IS
    v_item_seqno item.item_seqno%TYPE;
    v_pro_seqno pro.pro_seqno%TYPE;
    v_att_seqno att.att_seqno%TYPE;
BEGIN
    v_item_seqno := item_seqno.nextval;
    v_pro_seqno :=  pro_seqno.nextval;
    v_att_seqno :=  att_seqno.nextval;
    
    insert into item(item_seqno,item_detail,item_name,mem_id) values(v_item_seqno, p_prolit.p_item_deatile, p_prolit.p_item_name, p_prolit.p_mem_id);
    

    insert into pro(pro_seqno, pro_price, cat_seqno, pro_saleprice, pro_opendate, pro_closedate, pro_detail, mem_id, item_seqno, pro_amount, pro_stat)
            values (v_pro_seqno, p_prolit.p_pro_price, p_prolit.p_pro_hits, p_prolit.p_pro_saleprice, p_prolit.p_pro_opendate, p_prolit.p_pro_closedate, 
            p_prolit.p_pro_detail, p_prolit.p_mem_id, v_item_seqno, p_prolit.p_pro_amount , p_prolit.p_pro_stat);

    
    insert into att(att_seqno, item_seqno, att_name, att_savename, att_size, att_type, att_path)
                values(v_att_seqno, v_item_seqno, p_prolit.att.p_att_name, p_prolit.att.p_att_savename, p_prolit.att.p_att_size, p_prolit.att.p_att_type, p_prolit.att.p_att_path);
                
    
    insert into att_thumb(thumb_seqno, thumb_filename, thumb_filesize, thumb_filepath, att_seqno)
                values (thumb_seqno.nextval, p_prolit.att.p_att_thumb.p_attth_name, p_prolit.att.p_att_thumb.p_attth_size, 
                p_prolit.att.p_att_thumb.p_attth_path, v_att_seqno);
    
    p_pro_seqno := v_pro_seqno;

END;







--�׽�Ʈ ���ν���
/
desc item;
CREATE OR REPLACE TYPE obj_promodify IS OBJECT(
    p_proStat             VARCHAR2(50),
    p_proPrice            NUMBER,
    p_proHits             NUMBER,
    p_proSaleprice        NUMBER,
    p_proOpendate         varchar2(500),
    p_proClosedate        varchar2(500),
    p_proDetail           VARCHAR2(1000),
    p_seqno               NUMBER,
    p_proAmount           NUMBER,
    p_itemDetail          VARCHAR2(50),
    p_itemName            VARCHAR2(500),
    p_itemseqno           NUMBER,
    att                   obj_att
);
CREATE OR REPLACE PROCEDURE P_PRO_MODIFY(
    p_promodi  in obj_promodify
)
IS
    CURSOR item_cur (v_itemseqno item.item_seqno%TYPE) IS
    select item_name, item_detail from item where item_seqno = v_itemseqno for update nowait;
    
    CURSOR pro_cur (v_seqno pro.pro_seqno%TYPE)IS
    select pro_stat, pro_price, pro_hits, pro_saleprice, pro_opendate, pro_closedate, pro_detail, pro_amount 
    from pro where pro_seqno = v_seqno for update nowait;
    v_att_seqno att.att_seqno%TYPE;
BEGIN
    FOR i IN item_cur(p_promodi.p_itemseqno) LOOP
        UPDATE item
        SET item_name = p_promodi.p_itemName,
        item_detail = p_promodi.p_itemDetail
        WHERE CURRENT OF item_cur;
    END LOOP;
    
    FOR i IN pro_cur(p_promodi.p_seqno) LOOP
        UPDATE pro set
        pro_stat = p_promodi.p_proStat,
        pro_price = p_promodi.p_proPrice,
        pro_hits = p_promodi.p_proHits,
        pro_saleprice = p_promodi.p_proSaleprice,
        pro_opendate = p_promodi.p_proOpendate,
        pro_closedate = p_promodi.p_proClosedate,
        pro_detail = p_promodi.p_proDetail,
        pro_amount = p_promodi.p_proAmount
        WHERE CURRENT OF pro_cur;
    END LOOP;
    
    if p_promodi.att.p_att_name is not null then
    
    v_att_seqno := att_seqno.nextval;
    
    insert into att(att_seqno, item_seqno, att_name, att_savename, att_size, att_type, att_path)
                values(v_att_seqno, p_promodi.p_itemseqno, p_promodi.att.p_att_name, p_promodi.att.p_att_savename, p_promodi.att.p_att_size, p_promodi.att.p_att_type, p_promodi.att.p_att_path);


    insert into att_thumb(thumb_seqno, thumb_filename, thumb_filesize, thumb_filepath, att_seqno)
                values (thumb_seqno.nextval, p_promodi.att.p_att_thumb.p_attth_name, p_promodi.att.p_att_thumb.p_attth_size, 
                p_promodi.att.p_att_thumb.p_attth_path, v_att_seqno);
    end if;
    
    commit;
END;
    
/   

begin
    P_PRO_MODIFY('PRO_ING',200,1,20,'2022/08/31','2022/09/30','��ȫ��2',19,1,'��ȫ��','��ȫ��',30);
end;

/

--��ٱ���

create or replace NONEDITIONABLE TYPE mycart_proseqnolist is TABLE of number;

create or replace NONEDITIONABLE PROCEDURE p_mycart(
    p_id IN mem.mem_id%TYPE,
    p_proseqno IN mycart_proseqnolist,
    p_cartlist OUT sys_refcursor
)
IS
    v_sql VARCHAR2(3000);
    curid NUMBER;
    ret   NUMBER;
BEGIN
    
    v_sql := 'select (select item_name from item i where i.item_seqno = p.item_seqno) item_name,
                    (select item_seqno from item i where i.item_seqno = p.item_seqno) item_seqno,
                    (select (select (select thumb_filename 
                                     from att_thumb at where at.att_seqno = a.att_seqno)
                            from att a where a.item_seqno = i.item_seqno) 
                     from item i where i.item_seqno = p.item_seqno ) item_img,
                     c.cart_seqno as cart_seqno, c.cart_amount as cart_amount,p.pro_price as pro_price,
                     p.pro_seqno as pro_seqno,(p.pro_price * c.cart_amount) as totalprice 
              from (select * from cart where mem_id = :a ) c, (select * from pro p ';
            IF p_proseqno(1) is not null then
                v_sql := v_sql || 'where pro_seqno in ( ';
                FOR i IN p_proseqno.FIRST..p_proseqno.LAST
                LOOP
                  IF i = p_proseqno.LAST THEN v_sql := v_sql ||':'||i ; 
                  else v_sql := v_sql ||':'||i||',' ;
                  END IF;
                END LOOP;       
                  v_sql := v_sql ||')';
            END IF;
                v_sql := v_sql || ') p  where c.pro_seqno = p.pro_seqno';
                DBMS_OUTPUT.PUT_LINE(v_sql);
    --Ŀ�� ����
    curid := DBMS_SQL.OPEN_CURSOR;
    --SQL �Ľ�
        DBMS_SQL.PARSE(curid,v_sql,DBMS_SQL.NATIVE);
        --���ε� ����
        
        DBMS_SQL.BIND_VARIABLE(curid, ':a', p_id);
    IF p_proseqno(1) is not null then
        
                FOR i IN p_proseqno.FIRST..p_proseqno.LAST
                LOOP
                    DBMS_SQL.BIND_VARIABLE(curid, ':'||i, p_proseqno(i));
                END LOOP;
        
    END IF;
    --SQL������
        ret := DBMS_SQL.EXECUTE(curid);

    --Ŀ�� id�� �̿��ؼ� Ŀ�� ������ ����
    p_cartlist := DBMS_SQL.TO_REFCURSOR(curid);
    
    exception when others then
    v_sql := v_sql || ') p  where c.pro_seqno = p.pro_seqno';
--    DBMS_OUTPUT.PUT_LINE(v_sql);
    --Ŀ�� ����
    curid := DBMS_SQL.OPEN_CURSOR;
    DBMS_SQL.PARSE(curid,v_sql,DBMS_SQL.NATIVE);
    DBMS_SQL.BIND_VARIABLE(curid, ':a', p_id);
    
    ret := DBMS_SQL.EXECUTE(curid);
    

    --Ŀ�� id�� �̿��ؼ� Ŀ�� ������ ����
    p_cartlist := DBMS_SQL.TO_REFCURSOR(curid);
--    DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;

/

DECLARE
    v_cartlist sys_refcursor;
    v_proseqno mycart_proseqnolist := mycart_proseqnolist(null);
    type v_listrec is record(
        item_name       item.item_name%TYPE,
        item_seqno      item.item_seqno%TYPE,
        item_img        att_thumb.thumb_filename%TYPE,
        cart_seqno      cart.cart_seqno%TYPE,
        cart_amount     cart.cart_amount%TYPE,
        pro_price       pro.pro_price%TYPE,
        pro_seqno       pro.pro_seqno%TYPE,
        totalprice      number
    );
    v_list v_listrec;
BEGIN
    p_mycart('ccc',v_proseqno,v_cartlist);
    LOOP
    FETCH v_cartlist into v_list;
    EXIT WHEN v_cartlist%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(v_list.item_img||','||v_list.item_name);
    END LOOP;
    close v_cartlist;
END;
/
--�����ϱ� �� order���̺��߰�

CREATE OR REPLACE PROCEDURE p_orderadd(
    p_pay_method orderdetail.orderdetail_way%TYPE,
    p_buyer_name orderdetail.orderdetail_buyer%TYPE,
    p_buyer_tel orderdetail.orderdetail_phone%TYPE,
    p_merchant_uid orders.order_paynum%TYPE,
    p_totalprice orders.order_totalprice%TYPE,
    p_mem_id    mem.mem_id%TYPE,
    p_cart_seqno t_orders_cartseqno,
    p_cart_amount t_orders_cartamount,
    v_order_seqno out orders.order_seqno%TYPE
)
IS
    z NUMBER := 0;
    v_proseqnocur SYS_REFCURSOR;
    TYPE v_pro_seqnorec IS TABLE OF number INDEX BY PLS_INTEGER;
    v_proseqno  v_pro_seqnorec;
    v_sql VARCHAR2(3000);
    curid NUMBER;
    ret   NUMBER;
BEGIN
    v_sql := ' select pro_seqno from cart where cart_seqno in (';
                                        FOR i IN p_cart_seqno.FIRST..p_cart_seqno.LAST
                                        LOOP
                                          IF i = p_cart_seqno.LAST THEN v_sql := v_sql ||p_cart_seqno(i) ; 
                                          else v_sql := v_sql ||p_cart_seqno(i)||',' ;
                                          END IF;
                                        END LOOP;     
                            v_sql := v_sql ||')';
                            
    OPEN v_proseqnocur for v_sql;
    LOOP
    FETCH v_proseqnocur INTO v_proseqno(z);
    EXIT WHEN v_proseqnocur%NOTFOUND;
    z := z+1;
    END LOOP;
    
    
    SELECT order_seqno.nextval into v_order_seqno from dual;
    
    INSERT INTO orders(order_seqno, order_totalprice, mem_id, order_paynum) values (v_order_seqno,p_totalprice,p_mem_id,p_merchant_uid);                
    z := 0;               
    FOR i IN p_cart_amount.first..p_cart_amount.last
    LOOP
    INSERT INTO mini_order(mini_seqno,pro_seqno,order_seqno,amount) 
    VALUES (mini_seqno.nextval, v_proseqno(z),v_order_seqno,p_cart_amount(i));
    z := z+1;
    END LOOP;
    
    z := 0;
    FOR i IN p_cart_amount.first..p_cart_amount.last
    LOOP
    UPDATE pro set pro_amount = pro_amount - p_cart_amount(i) where pro_seqno = v_proseqno(z);
    z := z+1;
    END LOOP;        
    
    INSERT INTO orderdetail(orderdetail_seqno, orderdetail_way, orderdetail_buyer, orderdetail_phone, order_seqno) 
                    values (orderdetail_seqno.nextval, p_pay_method, p_buyer_name, p_buyer_tel, v_order_seqno);
                    
 
    FOR i IN p_cart_seqno.first..p_cart_seqno.last
    LOOP
        delete from cart where cart_seqno in (p_cart_seqno(i));
    END LOOP;
END;

/

DECLARE
    p_cart_seqno    t_orders_cartseqno := t_orders_cartseqno(13);
    p_cart_amount   t_orders_cartamount := t_orders_cartamount(2);
    v_seqno orders.order_seqno%TYPE;
BEGIN
    p_orderadd('point','��ȫ��','010','ORD20220912-121036183','100000','ccc',p_cart_seqno,p_cart_amount,v_seqno);
    DBMS_OUTPUT.PUT_LINE(v_seqno);
END;

/

--���� �� ����Ʈ

CREATE OR REPLACE PROCEDURE p_orders_list(
    p_order_seqno orders.order_seqno%TYPE,
    p_ordercur out SYS_REFCURSOR
)
IS
BEGIN

    open p_ordercur for 
        select (select item_name from item i where i.item_seqno = p.item_seqno) as item_name,
            (select item_seqno from item i where i.item_seqno = p.item_seqno) as item_seqno,
            (select(select(select thumb_filename from att_thumb at where at.att_seqno = a.att_seqno) 
                 from att a where a.item_seqno = i.item_seqno) 
            from item i where i.item_seqno = p.item_seqno) item_img,
            p.pro_price as pro_price, m.amount as amount,(p.pro_price * amount) as price
        from pro p,(select pro_seqno, amount from mini_order where order_seqno = p_order_seqno)m
        where p.pro_seqno = m.pro_seqno;
        
END;
/
DECLARE
    v_seqno number := number(63);
    v_list SYS_REFCURSOR;
    item_name       item.item_name%TYPE;
    item_seqno      item.item_seqno%TYPE;
    item_img        att_thumb.thumb_filename%TYPE;
    pro_price       pro.pro_price%TYPE;
    amount          mini_order.amount%TYPE;
    price           number;
BEGIN
    p_orders_list(v_seqno,v_list);
    LOOP
        FETCH v_list INTO item_name, item_seqno, item_img, pro_price, amount, price;
        EXIT WHEN v_list%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(item_img);
    END LOOP;
END;
/
-- pro ������ ������
CREATE OR REPLACE PROCEDURE p_prodetail(
    p_proseqno pro.pro_seqno%TYPE,
    p_prodetail out SYS_REFCURSOR,
    p_proatt    out SYS_REFCURSOR
)
IS
    v_itemseqno item.item_seqno%TYPE;
BEGIN
    OPEN p_prodetail FOR select (select item_name from item i where i.item_seqno = p.item_seqno) as item_name, 
                        (select item_img from item i where i.item_seqno = p.item_seqno) as item_img, 
                        (select item_detail from item i where i.item_seqno = p.item_seqno) as item_detail, 
                        (select item_seqno from item i where i.item_seqno = p.item_seqno) as item_seqno, 
                        cat_seqno, pro_stat, pro_price, TO_CHAR(pro_opendate,'YYYY-MM-DD') as pro_opendate, 
                        TO_CHAR(pro_closedate,'YYYY-MM-DD') as pro_closedate, pro_detail,pro_saleprice,pro_amount
                        from pro p where pro_seqno = p_proseqno ;
                        
        SELECT item_seqno INTO v_itemseqno FROM pro p where p.pro_seqno = p_proseqno;
        
        OPEN p_proatt FOR select att_name,att_savename,thumb_filename, att_path, thumb_filepath,
                                a.att_seqno as att_seqno
                            from att a, att_thumb at
                            where a.att_seqno = at.att_seqno
                            and item_seqno = v_itemseqno;
END;

/

--��ž����� �߰� AUCADD
create or replace NONEDITIONABLE TYPE obj_auc IS OBJECT(
    p_item_name      VARCHAR2(500),
    p_mem_id         VARCHAR2(50),
    p_auc_stat      VARCHAR2(50),
    p_auc_price     NUMBER,
    p_auc_start     VARCHAR2(50),
    p_auc_finish   varchar2(500),
    p_auc_shortdetail  varchar2(500),
    p_auc_detail     VARCHAR2(1000),
    att              obj_att
);
CREATE OR REPLACE PROCEDURE p_aucadd(
    p_auclist   obj_auc,
    p_auc_seqno OUT auc.auc_seqno%TYPE
)
IS
    v_item_seqno item.item_seqno%TYPE;
    v_auc_seqno auc.auc_seqno%TYPE;
    v_att_seqno att.att_seqno%TYPE;
BEGIN
    v_item_seqno := item_seqno.nextval;
    v_auc_seqno :=  auc_seqno.nextval;
    v_att_seqno :=  att_seqno.nextval;
    
    insert into item(item_seqno,item_name,mem_id) values (v_item_seqno, p_auclist.p_item_name, p_auclist.p_mem_id);
    
    insert into auc(auc_seqno, auc_stat, auc_price, auc_start, auc_finish,auc_shortdetail, auc_detail,item_seqno, auc_closeprice) 
            values (v_auc_seqno, p_auclist.p_auc_stat, p_auclist.p_auc_price, p_auclist.p_auc_start, p_auclist.p_auc_finish, 
            p_auclist.p_auc_shortdetail, p_auclist.p_auc_detail, v_item_seqno, p_auclist.p_auc_price);
    
    insert into att(att_seqno, item_seqno, att_name, att_savename, att_size, att_type, att_path)
                values(v_att_seqno, v_item_seqno, p_auclist.att.p_att_name, p_auclist.att.p_att_savename, p_auclist.att.p_att_size, p_auclist.att.p_att_type, p_auclist.att.p_att_path);

    
    insert into att_thumb(thumb_seqno, thumb_filename, thumb_filesize, thumb_filepath, att_seqno)
                values (thumb_seqno.nextval, p_auclist.att.p_att_thumb.p_attth_name, p_auclist.att.p_att_thumb.p_attth_size, 
                p_auclist.att.p_att_thumb.p_attth_path, v_att_seqno);

    p_auc_seqno := v_auc_seqno;
    
END;

--auc ������������ ���ϵ�����
CREATE OR REPLACE PROCEDURE p_aucdetail(
    p_proseqno pro.pro_seqno%TYPE,
    p_prodetail out SYS_REFCURSOR,
    p_proatt    out SYS_REFCURSOR
)
IS
    v_itemseqno item.item_seqno%TYPE;
BEGIN
    OPEN p_prodetail FOR select (select item_name from item i where i.item_seqno = a.item_seqno) as item_name,
                            (select item_seqno from item i where i.item_seqno = a.item_seqno) as item_seqno,
                            to_char(auc_start,'YYYY-MM-DD') as auc_start,
                            to_char(auc_finish,'YYYY-MM-DD') as auc_finish,
                            auc_stat,auc_price,auc_shortdetail,auc_detail,auc_seqno
                            from auc a
                            where auc_seqno = p_proseqno;
                        
        SELECT item_seqno INTO v_itemseqno FROM auc p where p.auc_seqno = p_proseqno;
        
        OPEN p_proatt FOR select att_name,att_savename,thumb_filename, att_path, thumb_filepath,
                                a.att_seqno as att_seqno
                            from att a, att_thumb at
                            where a.att_seqno = at.att_seqno
                            and item_seqno = v_itemseqno;
END;
/
--aucmodify
create or replace NONEDITIONABLE TYPE obj_aucmodi IS OBJECT(
    p_itemname      VARCHAR2(500),
    p_itemseqno    number,
    p_aucseqno      number,
    p_aucstat      VARCHAR2(50),
    p_aucprice     NUMBER,
    p_aucstart     VARCHAR2(50),
    p_aucfinish   varchar2(500),
    p_aucshortdetail  varchar2(500),
    p_aucdetail     VARCHAR2(1000),
    att              obj_att
);
create or replace NONEDITIONABLE PROCEDURE p_auc_modify(
    p_aucmodi  in obj_aucmodi
)
IS
    CURSOR item_cur (v_itemseqno item.item_seqno%TYPE) IS
    select item_name from item where item_seqno = v_itemseqno for update nowait;

    CURSOR auc_cur (v_seqno auc.auc_seqno%TYPE)IS
    select auc_stat, auc_price, auc_start, auc_finish, auc_shortdetail, auc_detail 
    from auc where auc_seqno = v_seqno for update nowait;
    v_att_seqno att.att_seqno%TYPE;
BEGIN
    FOR i IN item_cur(p_aucmodi.p_itemseqno) LOOP
        UPDATE item
        SET item_name = p_aucmodi.p_itemname
        WHERE CURRENT OF item_cur;
    END LOOP;

    FOR i IN auc_cur(p_aucmodi.p_aucseqno) LOOP
        UPDATE auc set
        auc_stat = p_aucmodi.p_aucstat,
        auc_price = p_aucmodi.p_aucprice,
        auc_start = p_aucmodi.p_aucstart,
        auc_finish = p_aucmodi.p_aucfinish,
        auc_shortdetail = p_aucmodi.p_aucshortdetail,
        auc_detail = p_aucmodi.p_aucdetail
        WHERE CURRENT OF auc_cur;
    END LOOP;

    if p_aucmodi.att.p_att_name is not null then

    v_att_seqno := att_seqno.nextval;

    insert into att(att_seqno, item_seqno, att_name, att_savename, att_size, att_type, att_path)
                values(v_att_seqno, p_aucmodi.p_itemseqno, p_aucmodi.att.p_att_name, p_aucmodi.att.p_att_savename, p_aucmodi.att.p_att_size, p_aucmodi.att.p_att_type, p_aucmodi.att.p_att_path);


    insert into att_thumb(thumb_seqno, thumb_filename, thumb_filesize, thumb_filepath, att_seqno)
                values (thumb_seqno.nextval, p_aucmodi.att.p_att_thumb.p_attth_name, p_aucmodi.att.p_att_thumb.p_attth_size, 
                p_aucmodi.att.p_att_thumb.p_attth_path, v_att_seqno);

    END IF;
    commit;
END;
/
--ũ�������� �Ǹ��� �ݾ�
CREATE OR REPLACE PROCEDURE p_totalm(
    p_id mem.mem_id%TYPE,
    p_totalmn out INTEGER
)
IS
    v_totalcur sys_refcursor;
BEGIN
    open v_totalcur for select sum(total) as total
                            from
                            (
                            select sum(o.amount * p.pro_price) total
                                             from pro p,
                                                (
                                                select pro_seqno, mo.amount
                                                from orders o,
                                                    (
                                                    select pro_seqno,order_seqno,amount
                                                    from mini_order
                                                    ) mo
                                                where o.order_seqno = mo.order_seqno
                                                and o.order_seqno = (select od.order_seqno from orderdetail od where o.order_seqno = od.order_seqno and od.orderdetail_stat = 'END')
                                                ) o
                                             where p.pro_seqno = o.pro_seqno
                                             and mem_id = p_id
                                             union all
                                             select sum(auc_closeprice) total
                                             from 
                                                (
                                                select auc_closeprice,(select mem_id from item i where i.item_seqno = a.item_seqno) as mem_id
                                                from auc a,
                                                    (
                                                    select auc_seqno
                                                    from orders o,
                                                        (
                                                        select auc_seqno,order_seqno
                                                        from mini_order
                                                        ) mo
                                                    where o.order_seqno = mo.order_seqno
                                                    and o.order_seqno = (select od.order_seqno from orderdetail od where o.order_seqno = od.order_seqno and od.orderdetail_stat = 'END')
                                                    ) o
                                                where a.auc_seqno = o.auc_seqno
                                                )
                                             where mem_id = p_id
                                             );
        fetch v_totalcur into p_totalmn;
        
END;

DECLARE
    v_total INTEGER;
BEGIN
    p_totalm('ccc',v_total);
    DBMS_OUTPUT.PUT_LINE(v_total);
END;
/
/








