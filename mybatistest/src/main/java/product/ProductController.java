package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class ProductController {
	
	@Autowired  //서비스에 기능실행하라고 시킴
	@Qualifier("s")
	ProductService service;
	
	@RequestMapping("/productlist")
	//@ResponseBody 뷰있으면 이거 지우기
	public ModelAndView productList() {
		List<ProductVO> list = service.productList();//dao - sqlmapping - oracle
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist",list);
		mv.setViewName("/productlist");
		return mv; 
	}
	@RequestMapping("/productone")//url에 prdNo 파라미터 추가입력
	@ResponseBody
	public ProductVO productOne(String prdNo) {
		ProductVO vo = service.productOne(prdNo);
		return vo; 
	}
	@RequestMapping("/productinsert")
	@ResponseBody
	//나중에 jsp에서 form을통해 입력받는걸로 바꿔야함
	public String productInsert(ProductVO vo) {
		vo.setPrdNo("1004");
		vo.setPrdName("컴퓨터");
		vo.setPrdPrice(500000);
		vo.setPrdCompany("멀티");
		vo.setPrdStock(100);
		service.productInsert(vo);
		return "상품등록완료";
	}
	@RequestMapping("/productupdate")
	@ResponseBody
	public String productUpdate(ProductVO vo) {
		vo.setPrdNo("1004");
		vo.setPrdPrice(350000);
		service.productUpdate(vo);//이걸 실행해야 서비스가 dao시켜서 db에 업데이트
		return "상품수정완료";
	}
	@RequestMapping("/productdelete")//url에 prdStock 파라미터 추가입력
	@ResponseBody
	public String productDelete(int prdStock) {
		service.productDelete(prdStock);
		return "상품삭제완료";
	}

}

/*
 * http://localhost:9004/productinsert 실행
 * http://localhost:9004/productlist 실행 - 1004상품등록됐는지 확인
 * http://localhost:9004/productupdate 실행
 * http://localhost:9004/productlist 실행 - 1004상품가격변동여부 확인
 * http://localhost:9004/productdelete?prdStock=5
 * http://localhost:9004/productlist - prdStock=5인 상품삭제 확인
 * http://localhost:9004/producone?prdNo=1004
 * */
