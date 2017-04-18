package com.ss.json;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseMain {

	public static void main(String[] args) {
		//javascript Object Notaion
		/*{
			"name":"이긍열"			
		}위는 자바스크립트 표기법이기 때문에 불가능하다.*/
		
		//아래의 문자열은 현재까지는 그냥 문자열일뿐, 즉 아무런 의미가 없는 데이터일 뿐이다.
		//하지만, 추후에 json으로 인식시켜 사용해보자.
		//즉.. json parsing과정이 필요하다.
		/*"{";
			"\"name\":\"이긍열\"";
		"}";*/
		
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append(	"\"name\":\"기사식당\",");
		sb.append(	"\"loc\":\"서울시 관악구\",");
		sb.append(	"\"menus\":[");
		sb.append("{");
		sb.append("\"type\":\"면\",");
		sb.append("\"name\":\"우동\",");
		sb.append("\"price\":10000");
		sb.append("},");
		sb.append("{");
		sb.append("\"type\":\"백반\",");
		sb.append("\"name\":\"불고기백반\",");
		sb.append("\"price\":20000");
		sb.append("},");
		sb.append("{");
		sb.append("\"type\":\"고기\",");
		sb.append("\"name\":\"삼겹살\",");
		sb.append("\"price\":15000");
		sb.append("}");
		sb.append("]");
		sb.append("}");
		
		System.out.println(sb.toString());//	출력해서 인터넷사이트에서 유효성검사 해보자
		//위의 문자열을 자바언어가 json으로 처리하도록 해석해보자
		//이 작업을 위해서는 json을 이해하는 프로그램이 필요하다!!
		//javaSE에는 json파서가 포함되어 있지 않기 때문에 외부의 라이브러리를 이용해본다.
		
		JSONParser jsonParser=new JSONParser();
		try {
			//파싱한 결과물을 반환받자
			//파싱한 이후부터는 위의 json문자열을 마치 객체처럼 사용할 수 있다.
			//Object obj=jsonParser.parse(sb.toString());object형은 메소드가 별로 없기 때문에 jsonobject형으로 형변환하자
			
			JSONObject obj=(JSONObject)jsonParser.parse(sb.toString());
			String name=(String)obj.get("name");
			
			System.out.println(name);
			System.out.println((String)obj.get("loc"));
			
			//json표기법이 배열인 경우, 그 반환되는 값을 jsonarray로 받을 수 있다.
			JSONArray menus=(JSONArray)obj.get("menus");
			
			JSONObject json=(JSONObject)menus.get(0);
			System.out.println(json.get("name")+", "+json.get("price"));
			
			for (int i = 0; i < menus.size(); i++) {
				JSONObject jsons=(JSONObject)menus.get(i);
				System.out.println(jsons.get("type")+", "+ jsons.get("name")+", "+jsons.get("price"));
			}
			
			
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
