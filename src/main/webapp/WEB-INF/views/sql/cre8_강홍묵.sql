-------------로그인--------------
create or replace PROCEDURE p_login(
--변수선언
    p_id in mem.mem_id%type,
    v_member_cur out sys_refcursor
)
is
    v_sql varchar2(1000);

    curid number;
    ret number;
begin
      v_sql := 'select m.mem_id, m.mem_pw, m.mem_name, a.auth_name
                from mem m, mem_auth a 
                where m.mem_id = a.mem_id and m.mem_id = :1';    
    --커서오픈
    curid := DBMS_SQL.open_cursor;
    --sql 파싱
    dbms_sql.parse(curid, v_sql, dbms_sql.native);
    
    --바인드변수
    dbms_sql.bind_variable(curid, ':1', p_id);
    
    --sql문 실행
    ret := dbms_sql.execute(curid);

    --커서 id를 이용해서 커서변수에 저장
    v_member_cur := dbms_sql.to_refcursor(curid);
end;
/
--프로시저 테스트
declare
   v_member_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_member_rec is record(
        mem_id mem.mem_id%type,
        mem_pw mem.mem_pw%type,
        mem_name mem.mem_name%type,
        auth_name mem_auth.auth_name%type
   );
   v_member v_member_rec;
begin
    p_login('aaa', v_member_cur);
    
    loop
        fetch v_member_cur into v_member;
        exit when v_member_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_member.mem_id || ',' || v_member.mem_pw || ',' || v_member.mem_name || ',' || v_member.auth_name);
    end loop;
end;
/

create or replace procedure p_reginsert(
    p_id       in mem.mem_id%type,
    p_pw       in mem.mem_pw%type,
    p_tel     in mem.mem_tel%type,
    p_email   in mem.mem_email%type,
    p_birth    in mem.mem_birth%type,
    p_name    in mem.mem_name%type,
    p_chek    in mem.mem_check%type
)
is
begin
    insert into mem (mem_id, mem_pw, mem_tel, mem_email, mem_birth, mem_name, mem_check) 
            values (p_id, p_pw, p_tel, p_email, p_birth, p_name, p_chek);
end;
/
declare
begin
    p_reginsert('joy999888899','1111','010-1111-1111','F','960309','ㅇ@ㅇ','Y');
end;
/

create or replace PROCEDURE p_mypage(
--변수선언
    p_id in mem.mem_id%type,
    v_mypage_cur out sys_refcursor
)
is
    v_sql varchar2(1000);

    curid number;
    ret number;
begin
      v_sql := 'select m.mem_id, m.mem_email, m.mem_tel, m.mem_name,
                nvl(a.add_address, ''주소를 입력하세요'') as add_address
                from mem m, address a
                where m.mem_id = a.mem_id(+)
                and m.mem_id = :1';    
    --커서오픈
    curid := DBMS_SQL.open_cursor;
    --sql 파싱
    dbms_sql.parse(curid, v_sql, dbms_sql.native);
    
    --바인드변수
    dbms_sql.bind_variable(curid, ':1', p_id);    
    
    --sql문 실행
    ret := dbms_sql.execute(curid);

    --커서 id를 이용해서 커서변수에 저장
    v_mypage_cur := dbms_sql.to_refcursor(curid);
end;
/
--프로시저 테스트
declare
   v_mypage_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_mypage_rec is record(
        mem_id mem.mem_id%type,
        mem_email mem.mem_email%type,
        mem_tel mem.mem_tel%type,
        mem_name mem.mem_name%type,
        add_address address.add_address%type
   );
   v_mypage v_mypage_rec;
begin
    p_mypage('aaa', v_mypage_cur);
    
    loop
        fetch v_mypage_cur into v_mypage;
        exit when v_mypage_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_mypage.mem_id || ',' || v_mypage.mem_email || ',' || v_mypage.mem_tel || ',' || v_mypage.add_address);
    end loop;
end;
/
create or replace PROCEDURE p_info(
--변수선언
    p_id in mem.mem_id%type,
    v_info_cur out sys_refcursor
)
is
    v_sql varchar2(1000);

    curid number;
    ret number;
begin
      v_sql := 'select a.add_detail, m.mem_name, m.mem_email, m.mem_tel,
                m.mem_snsinfo, m.mem_img, a.add_category,
                a.add_phone, a.add_person, a.add_address
                from mem m, address a
                where m.mem_id = a.mem_id(+)
                and m.mem_id = :1 ';    
    --커서오픈
    curid := DBMS_SQL.open_cursor;
    --sql 파싱
    dbms_sql.parse(curid, v_sql, dbms_sql.native);
    --바인드변수
    dbms_sql.bind_variable(curid, ':1', p_id);  
    --sql문 실행
    ret := dbms_sql.execute(curid);

    --커서 id를 이용해서 커서변수에 저장
    v_info_cur := dbms_sql.to_refcursor(curid);
end;
/
declare
   v_info_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_info_rec is record(
        add_detail address.add_detail%type,
        mem_name mem.mem_name%type,
        mem_email mem.mem_email%type,
        mem_tel mem.mem_tel%type,
        mem_snsinfo mem.mem_snsinfo%type,
        mem_img mem.mem_img%type,
        add_category address.add_category%type,
        add_phone address.add_phone%type,
        add_person address.add_person%type,
        add_address address.add_address%type
   );
   v_info v_info_rec;
begin
    p_info('aaa', v_info_cur);
    
    loop
        fetch v_info_cur into v_info;
        exit when v_info_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_info.mem_name || ',' || v_info.mem_tel || ',' || v_info.add_phone || ',' || v_info.add_address);
    end loop;
end;
/

create or replace PROCEDURE p_membuylist(
--변수선언
    p_id in mem.mem_id%type,
    v_membuylist_cur out sys_refcursor
)
is
    v_sql varchar2(1000);

    curid number;
    ret number;
begin
      v_sql := 'select rownum, a.*
                from(
                select (select item_img from item i where i.item_seqno = p.item_seqno) item_img,
                (select item_name from item i where i.item_seqno = p.item_seqno) item_name,
                o.order_date order_date, o.amount order_amount, o.order_totalprice order_totalprice
                from pro p,
                (
                select order_totalprice, o.mem_id, pro_seqno, order_date, m.amount
                from orders o, mini_order m
                where o.order_seqno = m.order_seqno
                ) o
                where p.pro_seqno = o.pro_seqno and o.mem_id = :1
                order by order_date desc) a';    
    --커서오픈
    curid := DBMS_SQL.open_cursor;
    --sql 파싱
    dbms_sql.parse(curid, v_sql, dbms_sql.native);
    --바인드변수
    dbms_sql.bind_variable(curid, ':1', p_id);  
    --sql문 실행
    ret := dbms_sql.execute(curid);

    --커서 id를 이용해서 커서변수에 저장
    v_membuylist_cur := dbms_sql.to_refcursor(curid);
end;
/
declare
   v_membuylist_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_membuylist_rec is record(
        rownum integer,
        item_img item.item_img%type,
        item_name item.item_name%type,
        order_date orders.order_date%type,
        order_amount mini_order.amount%type,
        order_totalprice orders.order_totalprice%type
   );
   v_membuylist v_membuylist_rec;
begin
    p_membuylist('aaa', v_membuylist_cur);
    
    loop
        fetch v_membuylist_cur into v_membuylist;
        exit when v_membuylist_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_membuylist.item_img || ',' || v_membuylist.order_date || ',' || v_membuylist.order_amount || ',' || v_membuylist.order_totalprice);
    end loop;
end;
/
create or replace PROCEDURE p_memauclist_end(
--변수선언
    p_id in mem.mem_id%type,
    v_memauclist_cur out sys_refcursor
)
is
    v_sql varchar2(1000);

    curid number;
    ret number;
begin
      v_sql := 'select rownum, a.*
				  from(
				  select (select item_img from item i where i.item_seqno = p.item_seqno) item_img,
				  (select item_name from item i where i.item_seqno = p.item_seqno) item_name,
				  o.order_date order_date, o.amount order_amount, o.order_totalprice oreder_totalprice, p.auc_stat
				  from auc p,
				  (
				  select order_totalprice, o.mem_id, auc_seqno, order_date, m.amount
				  from orders o, mini_order m
				  where o.order_seqno = m.order_seqno
				  ) o
				  where p.auc_seqno = o.auc_seqno and o.mem_id = :1
				  order by order_date desc) a';    
    --커서오픈
    curid := DBMS_SQL.open_cursor;
    --sql 파싱
    dbms_sql.parse(curid, v_sql, dbms_sql.native);
    --바인드변수
    dbms_sql.bind_variable(curid, ':1', p_id);  
    --sql문 실행
    ret := dbms_sql.execute(curid);

    --커서 id를 이용해서 커서변수에 저장
    v_memauclist_cur := dbms_sql.to_refcursor(curid);
end;
/
declare
   v_memauclist_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_memauclist_rec is record(
        rownum integer,
        item_img item.item_img%type,
        item_name item.item_name%type,
        order_date orders.order_date%type,
        order_amount mini_order.amount%type,
        order_totalprice orders.order_totalprice%type,
        auc_stat auc.auc_stat%type
   );
   v_memauclist v_memauclist_rec;
begin
    p_memauclist_end('bbb', v_memauclist_cur);
    
    loop
        fetch v_memauclist_cur into v_memauclist;
        exit when v_memauclist_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_memauclist.item_img || ',' || v_memauclist.order_date || ',' || v_memauclist.order_amount || ',' || v_memauclist.order_totalprice);
    end loop;
end;
/
create or replace PROCEDURE p_memauclist_ing(
--변수선언
    p_id in mem.mem_id%type,
    v_memauclist_cur out sys_refcursor
)
is
    v_sql varchar2(1000);

    curid number;
    ret number;
begin
      v_sql := 'select rownum, a.*
				   from(
				   select a.auc_seqno, aucnow_date, (select item_name from item i where i.item_seqno = a.item_seqno) auc_name,
				   (select item_img from item i where i.item_seqno = a.item_seqno) auc_img,
				   a.auc_stat, a.auc_closeprice
				   from (select auc_seqno, Max(aucnow_date) as aucnow_date
				   from auc_nowing
				   where mem_id = :1
				   group by auc_seqno) an, auc a
				   where a.auc_seqno = an.auc_seqno
				   order by aucnow_date desc) a';    
    --커서오픈
    curid := DBMS_SQL.open_cursor;
    --sql 파싱
    dbms_sql.parse(curid, v_sql, dbms_sql.native);
    --바인드변수
    dbms_sql.bind_variable(curid, ':1', p_id);  
    --sql문 실행
    ret := dbms_sql.execute(curid);

    --커서 id를 이용해서 커서변수에 저장
    v_memauclist_cur := dbms_sql.to_refcursor(curid);
end;
/
declare
   v_memauclist_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_memauclist_rec is record(
        rownum integer,
        auc_seqno auc.auc_seqno%type,
        aucnow_date auc_nowing.aucnow_date%type,
        item_name item.item_name%type,
        item_img item.item_img%type,
        auc_stat auc.auc_stat%type,
        auc_closeprice auc.auc_closeprice%type
   );
   v_memauclist v_memauclist_rec;
begin
    p_memauclist_ing('aaa', v_memauclist_cur);
    
    loop
        fetch v_memauclist_cur into v_memauclist;
        exit when v_memauclist_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_memauclist.item_img || ',' || v_memauclist.auc_seqno || ',' || v_memauclist.auc_stat || ',' || v_memauclist.auc_closeprice);
    end loop;
end;
/
create or replace PROCEDURE buystat(
--변수선언
    p_id in mem.mem_id%type,
    v_buystat_cur out sys_refcursor
)
is
    v_sql varchar2(1000);

    curid number;
    ret number;
begin
      v_sql := 'select rownum, (select item_img from item i where i.item_seqno = p.item_seqno) item_img,
				    (select item_name from item i where i.item_seqno = p.item_seqno) item_name,
				    p.pro_price, a.order_date, a.orderdetail_stat, a.pro_seqno
				    from pro p,
				    (
				   select o.order_seqno, o.order_date, od.orderdetail_stat, o.pro_seqno
				    from (select o.order_seqno, o.order_date, m.pro_seqno from orders o, mini_order m 
				    where m.order_seqno = o.order_seqno and o.mem_id = :1) o,
				    (
				    select order_seqno, orderdetail_stat
				    from orderdetail
				    where orderdetail_stat not in ''END''
				    ) od
				    where o.order_seqno = od.order_seqno
				    order by o.order_date desc
				    ) a
				    where p.pro_seqno = a.pro_seqno';    
    --커서오픈
    curid := DBMS_SQL.open_cursor;
    --sql 파싱
    dbms_sql.parse(curid, v_sql, dbms_sql.native);
    --바인드변수
    dbms_sql.bind_variable(curid, ':1', p_id);  
    --sql문 실행
    ret := dbms_sql.execute(curid);

    --커서 id를 이용해서 커서변수에 저장
    v_buystat_cur := dbms_sql.to_refcursor(curid);
end;
/
declare
   v_buystat_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_buystat_rec is record(
        rownum integer,
        item_img item.item_img%type,
        item_name item.item_name%type,
        pro_price pro.pro_price%type,
        order_date orders.order_date%type,
        orderdetail_stat orderdetail.orderdetail_stat%type,
        pro_seqno pro.pro_seqno%type
   );
   v_buystat v_buystat_rec;
begin
    buystat('ccc', v_buystat_cur);
    
    loop
        fetch v_buystat_cur into v_buystat;
        exit when v_buystat_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_buystat.item_img || ',' || v_buystat.pro_seqno || ',' || v_buystat.order_date || ',' || v_buystat.orderdetail_stat);
    end loop;
end;
/
create or replace PROCEDURE ordercheck_order(
--변수선언
    p_id in mem.mem_id%type,
    v_ordercheck_order_cur out sys_refcursor
)
is
    v_sql varchar2(1000);

    curid number;
    ret number;
begin
      v_sql := 'SELECT *
				  FROM(
				     select o.order_seqno, d.orderdetail_way, o.order_date
				     from orders o, orderdetail d
				     where o.order_seqno=d.order_seqno
				     and o.mem_id = :1
				     order by o.order_date desc) a,
				     (select s.order_seqno, s.ship_seqno, w.waybill_name, w.waybill_number, s.add_address
				     from waybill w,
				                 (select s.order_seqno, s.ship_seqno, a.add_address, a.add_num
				                  from ship s, address a
				                  where s.add_seqno=a.add_seqno) s
				     where w.ship_seqno=s.ship_seqno) s
				  where a.order_seqno = s.order_seqno';    
    --커서오픈
    curid := DBMS_SQL.open_cursor;
    --sql 파싱
    dbms_sql.parse(curid, v_sql, dbms_sql.native);
    --바인드변수
    dbms_sql.bind_variable(curid, ':1', p_id);  
    --sql문 실행
    ret := dbms_sql.execute(curid);

    --커서 id를 이용해서 커서변수에 저장
    v_ordercheck_order_cur := dbms_sql.to_refcursor(curid);
end;
/
declare
   v_ordercheck_order_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_ordercheck_order_rec is record(
        order_seqno orders.order_seqno%type,
        orderdetail_way orderdetail.orderdetail_way%type,
        order_date orders.order_date%type,
        orrder_seqno orders.order_seqno%type,
        ship_seqno ship.ship_seqno%type,
        waybill_name waybill.waybill_name%type,
        waybill_number waybill.waybill_number%type,
        add_address address.add_address%type
   );
   v_ordercheck_order v_ordercheck_order_rec;
begin
    ordercheck_order('bbb', v_ordercheck_order_cur);
    
    loop
        fetch v_ordercheck_order_cur into v_ordercheck_order;
        exit when v_ordercheck_order_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_ordercheck_order.order_seqno || ',' || v_ordercheck_order.orderdetail_way || ',' || v_ordercheck_order.waybill_number || ',' || v_ordercheck_order.add_address);
    end loop;
end;
/
create or replace PROCEDURE ordercheck_detail(
--변수선언
    p_id in mem.mem_id%type,
    v_ordercheck_detail_cur out sys_refcursor
)
is
    v_sql varchar2(1000);

    curid number;
    ret number;
begin
      v_sql := 'select rownum, o.order_seqno, o.order_date, o.order_totalprice, s.ship_status
				from orders o, ship s
				where o.order_seqno = s.order_seqno
				and o.mem_id = :1
				order by o.order_seqno desc';    
    --커서오픈
    curid := DBMS_SQL.open_cursor;
    --sql 파싱
    dbms_sql.parse(curid, v_sql, dbms_sql.native);
    --바인드변수
    dbms_sql.bind_variable(curid, ':1', p_id);  
    --sql문 실행
    ret := dbms_sql.execute(curid);

    --커서 id를 이용해서 커서변수에 저장
    v_ordercheck_detail_cur := dbms_sql.to_refcursor(curid);
end;
/
declare
   v_ordercheck_detail_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_ordercheck_detail_rec is record(
        rownum integer, 
        order_seqno orders.order_seqno%type, 
        order_date orders.order_date%type,
        order_totalprice orders.order_totalprice%type,
        ship_status ship.ship_status%type
   );
   v_ordercheck_detail v_ordercheck_detail_rec;
begin
    ordercheck_detail('bbb', v_ordercheck_detail_cur);
    
    loop
        fetch v_ordercheck_detail_cur into v_ordercheck_detail;
        exit when v_ordercheck_detail_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_ordercheck_detail.order_seqno || ',' || v_ordercheck_detail.order_date || ',' || v_ordercheck_detail.order_totalprice || ',' || v_ordercheck_detail.ship_status);
    end loop;
end;
/
create or replace procedure p_infoupdate(
    p_snsinfo in mem.mem_snsinfo%type,
    p_email   in mem.mem_email%type,
    p_tel     in mem.mem_tel%type,
    p_id       in mem.mem_id%type,
    p_category in address.add_category%type,
    p_person in address.add_person%type,
    p_phone in address.add_phone%type,
    p_address in address.add_address%type,
    p_detail in address.add_detail%type
)
is
vs_no int := 0;
begin
    update mem set mem_email = p_email, mem_tel = p_tel, mem_snsinfo = p_snsinfo where mem_id = p_id;
    

    SELECT count(*) into vs_no FROM address WHERE mem_id = p_id;

    if vs_no >0 then
        update address set add_category = p_category, add_phone = p_phone, add_person = p_person, add_address = p_address, ADD_DETAIL = p_detail where mem_id = p_id;
    else
        insert into address(add_seqno, add_category, add_phone, add_person, add_address, ADD_DETAIL, mem_id) values (add_seqno.nextval, p_category, p_phone, p_person, p_address, p_detail, p_id);
    end if;   
    commit;
end;
/
declare
begin
    p_infoupdate('오라클sns','이메일@naver.com','010-3233-1222','ZZZ','회사','???','032-444-1111','서울','강남');
end;
/
---------------------------------------------------------------------------------------------------------------------
create or replace NONEDITIONABLE PROCEDURE p_adminLogin
(
    p_id in mem.mem_id%type,
    p_pw in mem.mem_pw%type,
    v_id out mem.mem_id%type,
    v_pw out mem.mem_pw%type
)
is
begin
    select m.mem_id, m.mem_pw into v_id, v_pw from mem m, mem_auth a
    where m.mem_id = a.mem_id 
    and (a.auth_name = 'A' or a.auth_name = 'M') 
    and m.mem_id = p_id;
exception
    when others then
        DBMS_OUTPUT.PUT_line('회원정보가 없습니다');
end;
/
--프로시저 테스트
declare
    v_id mem.mem_id%type;
    v_pw mem.mem_pw%type;
begin
    p_adminLogin('bbb', '1234', v_id, v_pw);
   
    DBMS_OUTPUT.PUT_LINE( v_id || ', ' || v_pw);
end;
/

-------------
--어드민 카테고리 검색입니다!
create or REPLACE procedure p_categorylist(
--바인드 변수 선언
    p_category in varchar2,
    p_keyword in varchar2,
    v_categorylist_cur out sys_refcursor
)
is
/* 추가예정
    v_rownum integer := p_current_page * p_row_per_page;
    v_rn integer := (p_current_page - 1 ) * p_row_per_page;
*/ 
    v_sql varchar2(1000);
    
    curid number;
    ret number;
    
begin
    v_sql := 'select rownum, c.cat_name, c.cat_regdate, c.cat_seqno as cat_seqno,
                (select mem.mem_name from mem where mem.mem_id = m.mem_id) name
			    from cat c, mem_auth m
			    where m.mem_id = c.mem_id';
                         
    if p_category is not null and p_category <> '999' then v_sql := v_sql || ' and cat_seqno = :1 '; end if;
    if p_keyword is not null then v_sql := v_sql || ' and cat_name like :2'; end if;

   --커서오픈
   curid := DBMS_SQL.open_cursor;
   --sql 파싱
   dbms_sql.parse(curid, v_sql, dbms_sql.native);
   
   if p_category is not null and p_category <> '999' then dbms_sql.bind_variable(curid, ':1', p_category); end if;
   if p_keyword is not null then dbms_sql.bind_variable(curid, ':2', '%'||p_keyword||'%'); end if;
   
   --sql문 실행
   ret := dbms_sql.execute(curid);
   
   --커서 id를 이용해서 커서변수에 저장
   v_categorylist_cur := dbms_sql.to_refcursor(curid);
end;
/
--프로시저 테스트
declare
   v_categorylist_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_categorylist_rec is record(
       rownum INTEGER, 
       cat_name cat.cat_name%type,
       cat_regdate cat.cat_regdate%type,
       cat_seqno cat.cat_seqno%type,
       mem_name mem.mem_name%type
   );
   v_categorylist v_categorylist_rec;
begin
    p_categorylist('999', '', v_categorylist_cur);
    
    loop
        fetch v_categorylist_cur into v_categorylist;
        exit when v_categorylist_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_categorylist.cat_name || ',' || v_categorylist.cat_regdate || ',' || v_categorylist.cat_seqno|| ',' || v_categorylist.mem_name);
    end loop;
end;
/
--멤버검색
create or REPLACE procedure p_memberlist(
--바인드 변수 선언
    p_category in varchar2,
    p_keyword in varchar2,
    p_classification in varchar2,
    v_memberlist_cur out sys_refcursor
)
is
/* 추가예정
    v_rownum integer := p_current_page * p_row_per_page;
    v_rn integer := (p_current_page - 1 ) * p_row_per_page;
*/ 
    v_sql varchar2(1000);
    
    curid number;
    ret number;
    
begin
    v_sql := 'select rownum, a.mem_id as mem_id, a.mem_name as mem_name, a.mem_tel as mem_tel, 
		        a.mem_email as mem_email, a.auth_date as auth_date, auth_name
                 from(
                 select m.mem_id, m.mem_name, m.mem_tel, m.mem_email, a.auth_date, 
		        decode(a.auth_name,''A'',''관리자'',''C'',''작가'',''M'',''마스터'',''U'',''일반회원'') auth_name
		        from mem m, mem_auth a
		        where m.mem_id = a.mem_id';
                
          case p_category
              when 'A' then v_sql := v_sql || ' and auth_name = ''A'' ';
              when 'U' then v_sql := v_sql || ' and auth_name = ''U'' ';
              when 'M' then v_sql := v_sql || ' and auth_name = ''M'' ';
              when 'C' then v_sql := v_sql || ' and auth_name = ''C'' ';
              else v_sql := v_sql || ' where 1=1 ';
          end case; 
          
             v_sql := v_sql || ' order by mem_name) a';

          case p_classification
              when '998' then v_sql := v_sql || ' where mem_id like :2 or mem_name like :2 or mem_tel like :2 or mem_email like :2 ';
              when 'mem_id' then v_sql := v_sql || ' where mem_id like :2 ';
              when 'mem_name' then v_sql := v_sql || ' where mem_name like :2 ';
              when 'mem_tel' then v_sql := v_sql || ' where mem_tel like :2 ';
              when 'mem_email' then v_sql := v_sql || ' where mem_email like :2 ';
              else v_sql := v_sql || ' where 1=1 ';
          end case;            
            
   --커서오픈
   curid := DBMS_SQL.open_cursor;
   --sql 파싱
   dbms_sql.parse(curid, v_sql, dbms_sql.native);
   
   case p_classification
        when '998' then dbms_sql.bind_variable(curid, ':2', '%'||p_keyword||'%');
        when 'mem_id' then dbms_sql.bind_variable(curid, ':2', '%'||p_keyword||'%');
        when 'mem_name' then dbms_sql.bind_variable(curid, ':2', '%'||p_keyword||'%');
        when 'mem_tel' then dbms_sql.bind_variable(curid, ':2', '%'||p_keyword||'%');
        when 'mem_email' then dbms_sql.bind_variable(curid, ':2', '%'||p_keyword||'%');
        else dbms_sql.bind_variable(curid, ':2', '%%');
   end case;   

   
   --sql문 실행
   ret := dbms_sql.execute(curid);
   
   --커서 id를 이용해서 커서변수에 저장
   v_memberlist_cur := dbms_sql.to_refcursor(curid);
end;
/
--프로시저 테스트
declare
   v_memberlist_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_memberlist_rec is record(
       rownum integer, 
       mem_id mem.mem_id%type,
       mem_name mem.mem_name%type,
       mem_tel mem.mem_tel%type, 
       mem_email mem.mem_email%type, 
       auth_date mem_auth.auth_date%type,
       auth_name mem_auth.auth_name%type
   );
   v_memberlist v_memberlist_rec;
begin
    p_memberlist('U', '무', 'mem_name', v_memberlist_cur);
    
    loop
        fetch v_memberlist_cur into v_memberlist;
        exit when v_memberlist_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_memberlist.mem_id || ',' || v_memberlist.mem_name || ',' || v_memberlist.mem_tel|| ',' || v_memberlist.mem_email);
    end loop;
end;
/
--마케팅검색
create or REPLACE procedure p_marketinglist(
--바인드 변수 선언
    p_keyword in varchar2,
    p_classification in varchar2,
    v_marketinglist_cur out sys_refcursor
)
is
/* 추가예정
    v_rownum integer := p_current_page * p_row_per_page;
    v_rn integer := (p_current_page - 1 ) * p_row_per_page;
*/ 
    v_sql varchar2(1000);
    
    curid number;
    ret number;
    
begin
    v_sql := 'select rownum, a.*
				 from(
				 select m.mar_seqno, m.mar_product, m.mar_company, m.mar_ceo, m.mar_phone, m.mar_regnum, m.mar_opendate
				 from marketing m
				 order by m.mar_opendate desc) a';
            
                case p_classification
                    when '999' then v_sql := v_sql || ' where mar_product like :1 or mar_company like :1 or mar_ceo like :1 or mar_phone like :1 or mar_regnum like :1 ';
                    when 'mar_product' then v_sql := v_sql || ' where mar_product like :1 ';
                    when 'mar_company' then v_sql := v_sql || ' where mar_company like :1 ';
                    when 'mar_ceo' then v_sql := v_sql || ' where mar_ceo like :1 ';
                    when 'mar_phone' then v_sql := v_sql || ' where mar_phone like :1 ';
                    when 'mar_regnum' then v_sql := v_sql || ' where mar_regnum like :1 ';                    
                    else v_sql := v_sql || ' where 1=1 ';
                end case;
            
   --커서오픈
   curid := DBMS_SQL.open_cursor;
   --sql 파싱
   dbms_sql.parse(curid, v_sql, dbms_sql.native);
   
   case p_classification
        when '999' then dbms_sql.bind_variable(curid, ':1', '%'||p_keyword||'%');
        when 'mar_product' then dbms_sql.bind_variable(curid, ':1', '%'||p_keyword||'%');
        when 'mar_company' then dbms_sql.bind_variable(curid, ':1', '%'||p_keyword||'%');
        when 'mar_ceo' then dbms_sql.bind_variable(curid, ':1', '%'||p_keyword||'%');
        when 'mar_phone' then dbms_sql.bind_variable(curid, ':1', '%'||p_keyword||'%');
        when 'mar_regnum' then dbms_sql.bind_variable(curid, ':1', '%'||p_keyword||'%');
        else dbms_sql.bind_variable(curid, ':1', '%%');
   end case;
   
   --sql문 실행
   ret := dbms_sql.execute(curid);
   
   --커서 id를 이용해서 커서변수에 저장
   v_marketinglist_cur := dbms_sql.to_refcursor(curid);
end;
/
--프로시저 테스트
declare
   v_marketinglist_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_marketinglist_rec is record(
       rownum integer,
       mar_seqno marketing.mar_seqno%type,
       mar_product marketing.mar_product%type,
       mar_company marketing.mar_company%type, 
       mar_ceo marketing.mar_ceo%type, 
       mar_phone marketing.mar_phone%type,
       mar_regnum marketing.mar_regnum%type,
       mar_opendate marketing.mar_opendate%type       
   );
   v_marketinglist v_marketinglist_rec;
begin
    p_marketinglist('2', 'mar_company', v_marketinglist_cur);
    
    loop
        fetch v_marketinglist_cur into v_marketinglist;
        exit when v_marketinglist_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_marketinglist.mar_seqno || ',' || v_marketinglist.mar_product || ',' || v_marketinglist.mar_company|| ',' || v_marketinglist.mar_ceo);
    end loop;
end;
/
--월별
create or REPLACE procedure p_monthlist(
--바인드 변수 선언
    v_monthlist_cur out sys_refcursor
)
is
/* 추가예정
    v_rownum integer := p_current_page * p_row_per_page;
    v_rn integer := (p_current_page - 1 ) * p_row_per_page;
*/ 
    v_sql varchar2(1000);
    
    curid number;
    ret number;
    
begin
    v_sql := 'select rownum, a.*
				from(
				select to_char(mar_opendate, ''YYYY-MM'') month, count(*) cnt, sum(mar_price) price
				from marketing 
				where mar_stat = ''FINISH'' or mar_stat = ''ING''
				group by to_char(mar_opendate,''YYYY-MM'')
				order by month) a';
            
   --커서오픈
   curid := DBMS_SQL.open_cursor;
   --sql 파싱
   dbms_sql.parse(curid, v_sql, dbms_sql.native);
   
   --sql문 실행
   ret := dbms_sql.execute(curid);
   
   --커서 id를 이용해서 커서변수에 저장
   v_monthlist_cur := dbms_sql.to_refcursor(curid);
end;
/
--프로시저 테스트
declare
   v_monthlist_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_monthlist_rec is record(
       rownum integer,
       month varchar2(50),
       cnt integer,
       price integer      
   );
   v_monthlist v_monthlist_rec;
begin
    p_monthlist(v_monthlist_cur);
    
    loop
        fetch v_monthlist_cur into v_monthlist;
        exit when v_monthlist_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_monthlist.rownum || ',' || v_monthlist.month || ',' || v_monthlist.cnt|| ',' || v_monthlist.price);
    end loop;
end;
/
--연간
create or REPLACE procedure p_yearlist(
--바인드 변수 선언
    v_yearlist_cur out sys_refcursor
)
is
/* 추가예정
    v_rownum integer := p_current_page * p_row_per_page;
    v_rn integer := (p_current_page - 1 ) * p_row_per_page;
*/ 
    v_sql varchar2(1000);
    
    curid number;
    ret number;
    
begin
    v_sql := 'select rownum, a.*
				from(
				select to_char(mar_opendate, ''YYYY'') year, count(*) cnt, sum(mar_price) price
				from marketing 
				where mar_stat = ''FINISH'' or mar_stat = ''ING''
				group by to_char(mar_opendate,''YYYY'')
				order by year) a';
            
   --커서오픈
   curid := DBMS_SQL.open_cursor;
   --sql 파싱
   dbms_sql.parse(curid, v_sql, dbms_sql.native);
   
   --sql문 실행
   ret := dbms_sql.execute(curid);
   
   --커서 id를 이용해서 커서변수에 저장
   v_yearlist_cur := dbms_sql.to_refcursor(curid);
end;
/
--프로시저 테스트
declare
   v_yearlist_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_yearlist_rec is record(
       rownum integer,
       year varchar2(50),
       cnt integer,
       price integer      
   );
   v_yearlist v_yearlist_rec;
begin
    p_yearlist(v_yearlist_cur);
    
    loop
        fetch v_yearlist_cur into v_yearlist;
        exit when v_yearlist_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_yearlist.rownum || ',' || v_yearlist.year || ',' || v_yearlist.cnt|| ',' || v_yearlist.price);
    end loop;
end;
/
declare
begin
    p_marketReg('0','0','0','0','2022/01/01','2022/02/02','0','0','0','0');
end;
/
--마케팅 구매내역 및 검색
create or replace NONEDITIONABLE procedure p_buylist(
--바인드 변수 선언
    p_classification in varchar2,
    p_keyword in varchar2,
    v_buylist_cur out sys_refcursor
)
is
/* 추가예정
    v_rownum integer := p_current_page * p_row_per_page;
    v_rn integer := (p_current_page - 1 ) * p_row_per_page;
*/ 
    v_sql varchar2(1000);

    curid number;
    ret number;

begin
    v_sql := 'SELECT rownum, d.*
				FROM(
				SELECT m.mar_opendate, a.mem_name, m.mar_price, count(*) over(partition by a.mem_name) count,
                    ((count(*) over(partition by a.mem_name)) * m.mar_price) total, m.mar_product, 
                    decode(m.mar_stat, ''ING'', ''판매중'', ''END'', ''판매종료'') as mar_stat
				FROM(
                    SELECT o.order_seqno, o.mem_id, o.order_date, o.mar_seqno, e.mem_name 
				FROM(
                    select o.order_seqno, o.mem_id, o.order_date, m.mar_seqno
                    from orders o, mini_order m 
                    where o.order_seqno = m.order_seqno) o, mem e
                    where e.mem_id = o.mem_id and o.mar_seqno is not null
                	order by o.order_date desc) a, marketing m
                 where m.mar_seqno = a.mar_seqno) d';
                
                   case p_classification
                        when '998' then v_sql := v_sql || ' where mar_stat like :1 or mar_product like :1 or mem_name like :1 ';
                        when 'mem_name' then v_sql := v_sql || ' where mem_name like :1 ';
                        when 'mar_product' then v_sql := v_sql || ' where mar_product like :1 ';
                        when 'mar_stat' then v_sql := v_sql || ' where mar_stat like :1 ';
                        else v_sql := v_sql || ' where 1=1 ';
                    end case;
   --커서오픈
   curid := DBMS_SQL.open_cursor;
   --sql 파싱
   dbms_sql.parse(curid, v_sql, dbms_sql.native);

   case p_classification
        when '998' then dbms_sql.bind_variable(curid, ':1', '%'||p_keyword||'%');
        when 'mem_name' then dbms_sql.bind_variable(curid, ':1', '%'||p_keyword||'%');
        when 'mar_product' then dbms_sql.bind_variable(curid, ':1', '%'||p_keyword||'%');
        when 'mar_stat' then dbms_sql.bind_variable(curid, ':1', '%'||p_keyword||'%');
        else dbms_sql.bind_variable(curid, ':1', '%%');
   end case;

           DBMS_OUTPUT.PUT_LINE(v_sql);

   --sql문 실행
   ret := dbms_sql.execute(curid);

   --커서 id를 이용해서 커서변수에 저장
   v_buylist_cur := dbms_sql.to_refcursor(curid);
end;
/
--프로시저 테스트
declare
   v_buylist_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_buylist_rec is record(
       rownum integer,
       mar_opendate marketing.mar_opendate%type,
       mem_name mem.mem_name%type,
       mar_price marketing.mar_price%type, 
       count integer, 
       total integer,
       mar_product marketing.mar_product%type,
       mar_stat marketing.mar_stat%type      
   );
   v_buylist v_buylist_rec;
begin
    p_buylist('mem_name', '영', v_buylist_cur);
    
    loop
        fetch v_buylist_cur into v_buylist;
        exit when v_buylist_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_buylist.mar_price || ',' || v_buylist.count || ',' || v_buylist.total|| ',' || v_buylist.mar_product);
    end loop;
end;
/
--마케팅 수정
create or REPLACE procedure p_modify(
--바인드 변수 선언
    p_seqno in marketing.mar_seqno%type,
    v_modify_cur out sys_refcursor
)
is

    v_sql varchar2(1000);
    
    curid number;
    ret number;
    
begin
    v_sql := 'select mar_seqno, mar_cate, mar_product, mar_price, mar_company,
				 mar_opendate, mar_closedate, mar_detail, mar_ceo, mar_phone, mar_regnum 
				 from marketing where mar_seqno = :1';
            
   --커서오픈
   curid := DBMS_SQL.open_cursor;
   --sql 파싱
   dbms_sql.parse(curid, v_sql, dbms_sql.native);
   
   dbms_sql.bind_variable(curid, ':1', p_seqno);
   
   --sql문 실행
   ret := dbms_sql.execute(curid);
   
   --커서 id를 이용해서 커서변수에 저장
   v_modify_cur := dbms_sql.to_refcursor(curid);
end;
/
--프로시저 테스트
declare
   v_modify_cur SYS_REFCURSOR; --내장커서 open, close 생략
   type v_modify_rec is record(
       mar_seqno marketing.mar_seqno%type,
       mar_cate marketing.mar_cate%type,
       mar_product marketing.mar_product%type, 
       mar_price marketing.mar_price%type,
       mar_company marketing.mar_company%type,      
       mar_opendate marketing.mar_opendate%type, 
       mar_closedate marketing.mar_closedate%type, 
       mar_detail marketing.mar_detail%type,
       mar_ceo marketing.mar_ceo%type, 
       mar_phone marketing.mar_phone%type, 
       mar_regnum marketing.mar_regnum%type
   );
   v_modify v_modify_rec;
begin
    p_modify('3', v_modify_cur);
    
    loop
        fetch v_modify_cur into v_modify;
        exit when v_modify_cur%notfound;
        DBMS_OUTPUT.PUT_LINE(v_modify.mar_opendate || ',' || v_modify.mar_closedate || ',' || v_modify.mar_ceo|| ',' || v_modify.mar_regnum);
    end loop;
end;
/
create or replace procedure p_marketReg(
    p_mar_seqno     in marketing.mar_seqno%type,
    p_mar_cate       in marketing.mar_cate%type,
    p_mar_product       in marketing.mar_product%type,
    p_mar_price     in marketing.mar_price%type,
    p_mar_company   in marketing.mar_company%type,
    p_mar_opendate    in marketing.mar_opendate%type,
    p_mar_closedate    in marketing.mar_closedate%type,
    p_mar_detail    in marketing.mar_detail%type,
    p_mar_ceo    in marketing.mar_ceo%type,
    p_mar_phone    in marketing.mar_phone%type,
    p_mar_regnum    in marketing.mar_regnum%type
)
is
begin
    update marketing set mar_cate =p_mar_cate, mar_product=p_mar_product, mar_price=p_mar_price, mar_company=p_mar_company, 
				mar_opendate=p_mar_opendate, mar_closedate=p_mar_closedate, mar_detail=p_mar_detail, mar_ceo=p_mar_ceo, mar_phone=p_mar_phone, mar_regnum=p_mar_regnum
				where mar_seqno =p_mar_seqno;
end;
/
declare
begin
    p_marketReg('3','0','0','0','0','2022/01/01','2022/02/02','0','0','0','0');
end;
/
create or replace NONEDITIONABLE procedure p_market_insert(
    p_att       obj_att,
    p_market    obj_mar,
    p_id        mem.mem_id%type
)
is
    v_att_seqno att.att_seqno%type;
    v_mar_seqno marketing.mar_seqno%type;
begin
    v_att_seqno := att_seqno.nextval;
    v_mar_seqno := mar_seqno.nextval;

    insert into marketing (mar_seqno, mar_cate, mar_product, mar_price, mar_company, 
				mar_opendate, mar_closedate, mar_detail, mar_ceo, mar_phone, mar_regnum)
            values (v_mar_seqno, p_market.p_mar_cate, p_market.p_mar_product, p_market.p_mar_price, p_market.p_mar_company, p_market.p_mar_opendate,
                    p_market.p_mar_closedate, p_market.p_mar_detail, p_market.p_mar_ceo, p_market.p_mar_phone, p_market.p_mar_regnum);

    INSERT INTO att (att_seqno, att_name, att_savename, att_size, att_type, att_path, mem_id)
            VALUES (v_att_seqno, p_att.p_att_name, p_att.p_att_savename, p_att.p_att_size, p_att.p_att_type, p_att.p_att_path, p_id);

    insert INTO att_thumb (thumb_seqno, thumb_filename, thumb_filesize, thumb_filepath, att_seqno) 
                VALUES (thumb_seqno.nextval, p_att.p_att_thumb.p_attth_name, p_att.p_att_thumb.p_attth_size, p_att.p_att_thumb.p_attth_path, v_att_seqno);

end;    
/
create or replace TYPE obj_mar IS OBJECT(
    p_mar_cate       varchar2(50),
    p_mar_product       varchar2(50),
    p_mar_price     varchar2(50),
    p_mar_company   varchar2(50),
    p_mar_opendate    varchar2(50),
    p_mar_closedate    varchar2(50),
    p_mar_detail    varchar2(1000),
    p_mar_ceo    varchar2(50),
    p_mar_phone    varchar2(50),
    p_mar_regnum    varchar2(50)
);
/
create or replace NONEDITIONABLE procedure p_marketModiy(
    p_att           obj_att,
    p_market        obj_mar,
    p_mar_seqno     in marketing.mar_seqno%type,
    p_id            in mem.mem_id%type
)
is
    v_att_seqno att.att_seqno%type;

begin
    v_att_seqno := att_seqno.nextval;

    update marketing set mar_cate =p_market.p_mar_cate, mar_product=p_market.p_mar_product, mar_price=p_market.p_mar_price, mar_company=p_market.p_mar_company, 
				mar_opendate=p_market.p_mar_opendate, mar_closedate=p_market.p_mar_closedate, mar_detail=p_market.p_mar_detail, mar_ceo=p_market.p_mar_ceo, mar_phone=p_market.p_mar_phone, mar_regnum=p_market.p_mar_regnum
				where mar_seqno = p_mar_seqno;

    INSERT INTO att (att_seqno, att_name, att_savename, att_size, att_type, att_path, mem_id, mar_seqno)
            VALUES (v_att_seqno, p_att.p_att_name, p_att.p_att_savename, p_att.p_att_size, p_att.p_att_type, p_att.p_att_path, p_id, p_mar_seqno);

    insert INTO att_thumb (thumb_seqno, thumb_filename, thumb_filesize, thumb_filepath, att_seqno) 
                VALUES (thumb_seqno.nextval, p_att.p_att_thumb.p_attth_name, p_att.p_att_thumb.p_attth_size, p_att.p_att_thumb.p_attth_path, v_att_seqno);
  
end;