			var index=0;
			// 点击上一张
			$("a:first").click(function(){
				prev_pic();
			})
			// 点击下一张
			$("a:last").click(function(){
				next_pic();
			})
			// 悬浮停止
			$(".wrapper").mouseover(function(){
				clearInterval(id);
			});
			$(".wrapper").mouseout(function(){
					autoplay();
			})
			
			
			// 下一张
			function next_pic(){
				index++;
				if(index>4){
					index=0;
				}
				addStyle();
			}
			
			// 上一张
			function prev_pic(){
				index--;
				if(index<0){
					index=4;
				}
				addStyle();
			}
			
			// 控制图片显示隐藏,小圆点背景色
			function addStyle(){
				$("img").eq(index).fadeIn();
				$("img").eq(index).siblings().fadeOut();
				$("span").eq(index).addClass("active");
				$("span").eq(index).siblings().removeClass("active");
			}
			
			// 自动轮播
			var id;
			autoplay();
			function autoplay(){
				id=setInterval(function(){
					next_pic();
				},3000)
			}
