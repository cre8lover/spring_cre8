package com.cre8.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.Cat;
import com.cre8.dto.Marketing;
import com.cre8.dto.MarketingVo;
import com.cre8.dto.Mem;
import com.cre8.service.AdminService;

@Controller
@RequestMapping("/master/")
public class Admincontroller {
	
	private static final Logger log = LoggerFactory.getLogger("Admincontroller.class");
	
	@Autowired
	private AdminService admin;
       

	@GetMapping("adminlogin")
	public String loginpage() {
		
		return "/admin/adminlogin";
	}
	
	@PostMapping("adminMain")
	public String adminpage(Mem mem, Model model, HttpSession sess) {
		
		String goView = null;
		
		String id = mem.getMemId();
		String pw = mem.getMemPw();
		
		Map<String, String> status = admin.login(id, pw);
		
		switch(status.get("login")) {
		case "ok" :
			
			sess.setAttribute("sess_id", id);
			sess.setAttribute("sess_name", status.get("name"));
			
			goView = "/admin/adminMain";
			break;
			
		case "pwfail" :
			
			model.addAttribute("err2", "占쏙옙橘占싫ｏ옙占� 확占쏙옙占쏙옙 占쌍쇽옙占쏙옙");
			goView = "/admin/adminlogin";
			
			break;
			
		case "no_member" :
			
			model.addAttribute("err2", "占쏙옙환占쏙옙 확占쏙옙占쏙옙占쌍쇽옙占쏙옙");
			goView = "/admin/adminlogin";
			
			break;
			
		default :
			
			goView = "/admin/adminlogin.jsp";

		}
		
		return goView;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession sess) {
	
		sess.invalidate();
		
		return "redirect:/admin/adminlogin";
	}
	
	@RequestMapping("category")
	public String categoryList(AdminKeyWord adkey, Model model) {
		
		List<Cat> category = admin.catelist(adkey);
		model.addAttribute("cate", category);
		model.addAttribute("key", adkey);
		
		return "/admin/category";
		
	}
	
	@RequestMapping("member")
	public String memberlist(AdminKeyWord adkey, Model model) {
		
		List<Mem> member = admin.memberlist(adkey);
		model.addAttribute("member", member);
		model.addAttribute("key", adkey);
		
		return "/admin/member";
	}
	
	@RequestMapping(value="creAd",
					produces="text/plain; charset=utf-8")
	public String marketingList() {
		
		log.info("광고 리스트 출력 컨트롤러.......................................");

		return "/admin/creAd";
	}
	
	@RequestMapping(value="marketingList/{page}.*",
					produces="application/json; charset=utf-8")
	public ResponseEntity<List<MarketingVo>> marketingList(AdminKeyWord adkey) {
		
		log.info("광고 리스트 출력 컨트롤러.......................................");
		
		return new ResponseEntity<List<MarketingVo>>(admin.marketingList(adkey), HttpStatus.OK);
	}
	
	@RequestMapping("adCheck")
	public String marketingCheck(AdminKeyWord adkey, Model model) {
	
		List<Marketing> list = admin.purchase(adkey);
		model.addAttribute("key", adkey);
		model.addAttribute("list", list);
		
		List<Marketing> month = admin.month();
		model.addAttribute("month", month);
		
		List<Marketing> year = admin.year();
		model.addAttribute("year", year);
		
		return "/admin/creAd2";
	}
	
	@RequestMapping(value="adreg",
					produces="text/plain; charset=utf-8")
	public String marketReg() {
		
		log.info("광고 등록 페이지 출력");
		
		return "/admin/admin_adreg";
	}
/*	
	@RequestMapping(value="marReg",
					produces="text/plain; charset=utf-8")
	public String marinsert(Marketing market, HttpSession sess, MultipartFile filename) {
		admin.reg(market, filename, (String)sess.getAttribute("sess_id"));

		log.info("광고 등록===================================");
		return "/admin/admin_adreg";
	}
*/	
	@RequestMapping(value="admodify/{mar}",
					produces="text/plain; charset=utf-8")
	public String marketingModify(@PathVariable("mar") String Seqno, Model model) {

		Marketing market = admin.modify(Seqno);

		model.addAttribute("market", market);
		return "/admin/admin_adreg2";
	}
/*	
	@RequestMapping(value="/modi/{marSeqno}.*",
			produces="application/json; charset=utf-8")
	public ResponseEntity<MarketingVo> get(@PathVariable("marSeqno") String marSeqno) {
		
		log.info("광고 수정  컨트롤러.......................................");
		
		return new ResponseEntity<MarketingVo>(admin.get(marSeqno), HttpStatus.OK);
	}
*/	
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH,RequestMethod.GET, RequestMethod.POST},
					value ="{marSeqno}", produces = "application/json; charset=utf-8")
	public ResponseEntity<String> update(@PathVariable("marSeqno") String marSeqno,
										@RequestBody MarketingVo vo) {
		
		log.info("광고 수정 요청==========================");
		
		return admin.update(vo) == 1 ? new ResponseEntity<>("정보가 수정되었습니다.", HttpStatus.OK) 
				   					  : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH,RequestMethod.GET, RequestMethod.POST},
					value ="add", consumes = "application/json", produces = "application/json; charset=utf-8")
	public ResponseEntity<String> add(@RequestBody MarketingVo vo) {

		log.info("광고 등록===================================");
		
		return admin.add(vo) == 1 ? new ResponseEntity<>("정보가 등록되었습니다.", HttpStatus.OK) 
									 : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value="/del/{marSeqno}", produces="text/plain; charset=utf-8")
	public ResponseEntity<String> remove(@PathVariable("marSeqno") Long marSeqno){
		log.info("delete marSeqno : " + marSeqno);
		
		return admin.remove(marSeqno) == 1 ? new ResponseEntity<>("삭제되었습니다", HttpStatus.OK) 
											: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
