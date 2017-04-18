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
			"name":"�̱࿭"			
		}���� �ڹٽ�ũ��Ʈ ǥ����̱� ������ �Ұ����ϴ�.*/
		
		//�Ʒ��� ���ڿ��� ��������� �׳� ���ڿ��ϻ�, �� �ƹ��� �ǹ̰� ���� �������� ���̴�.
		//������, ���Ŀ� json���� �νĽ��� ����غ���.
		//��.. json parsing������ �ʿ��ϴ�.
		/*"{";
			"\"name\":\"�̱࿭\"";
		"}";*/
		
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append(	"\"name\":\"���Ĵ�\",");
		sb.append(	"\"loc\":\"����� ���Ǳ�\",");
		sb.append(	"\"menus\":[");
		sb.append("{");
		sb.append("\"type\":\"��\",");
		sb.append("\"name\":\"�쵿\",");
		sb.append("\"price\":10000");
		sb.append("},");
		sb.append("{");
		sb.append("\"type\":\"���\",");
		sb.append("\"name\":\"�Ұ����\",");
		sb.append("\"price\":20000");
		sb.append("},");
		sb.append("{");
		sb.append("\"type\":\"���\",");
		sb.append("\"name\":\"����\",");
		sb.append("\"price\":15000");
		sb.append("}");
		sb.append("]");
		sb.append("}");
		
		System.out.println(sb.toString());//	����ؼ� ���ͳݻ���Ʈ���� ��ȿ���˻� �غ���
		//���� ���ڿ��� �ڹپ� json���� ó���ϵ��� �ؼ��غ���
		//�� �۾��� ���ؼ��� json�� �����ϴ� ���α׷��� �ʿ��ϴ�!!
		//javaSE���� json�ļ��� ���ԵǾ� ���� �ʱ� ������ �ܺ��� ���̺귯���� �̿��غ���.
		
		JSONParser jsonParser=new JSONParser();
		try {
			//�Ľ��� ������� ��ȯ����
			//�Ľ��� ���ĺ��ʹ� ���� json���ڿ��� ��ġ ��üó�� ����� �� �ִ�.
			//Object obj=jsonParser.parse(sb.toString());object���� �޼ҵ尡 ���� ���� ������ jsonobject������ ����ȯ����
			
			JSONObject obj=(JSONObject)jsonParser.parse(sb.toString());
			String name=(String)obj.get("name");
			
			System.out.println(name);
			System.out.println((String)obj.get("loc"));
			
			//jsonǥ����� �迭�� ���, �� ��ȯ�Ǵ� ���� jsonarray�� ���� �� �ִ�.
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
