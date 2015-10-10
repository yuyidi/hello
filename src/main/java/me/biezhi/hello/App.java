package me.biezhi.hello;

import com.blade.Blade;
import com.blade.Bootstrap;
import com.blade.route.RouteHandler;
import com.blade.servlet.Request;
import com.blade.servlet.Response;

import blade.kit.json.JSONObject;

/**
 * Hello Blade!
 */
public class App extends Bootstrap {

	@Override
	public void init() {}
	
	public static void main(String[] args) throws Exception {
		Blade blade = Blade.me();
		
		/**
		 * JDK1.6
		 */
		blade.get("/", new RouteHandler() {
			public Object handler(Request request, Response response) {
				response.html("<h1>Hello Blade！</h1>");
				return null;
			}
		});
		
		// java8
		blade.get("/hello").run( (req,res) -> {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", "biezhi");
			jsonObject.put("blog", "https://biezhi.me");
			res.json(jsonObject.toString());
			return null;
		});
		
		blade.app(App.class).listen(9001).start();
		
	}
	
}
