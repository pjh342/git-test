package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("s")
public class ProductServiceImpl implements ProductService{

	@Autowired //DAO한테 일을 시키는 클래스이다~
	ProductDAO dao;
	
	public List<ProductVO> productList() {
		List<ProductVO> list = dao.productList();
		return list;
	}

	@Override
	public ProductVO productOne(String prdNo) {
		return dao.productOne(prdNo);
	}

	@Override
	public void productInsert(ProductVO vo) {
		//상품등록기능
		//productOne에 PrdNo가 있는지 먼저 확인,
		//ProductVO vo로 리턴,
		//결과값이 null이면(없으면) 상품하나 추가
		ProductVO resultvo = dao.productOne(vo.getPrdNo());
		if(resultvo == null) {
			dao.productInsert(vo);
			//void라 리턴타입 없음
		}
	}

	@Override
	public void productUpdate(ProductVO vo) {
		dao.productUpdate(vo);
	}

	@Override
	public void productDelete(int prdStock) {
		dao.productDelete(prdStock);
	}
	
	
}
