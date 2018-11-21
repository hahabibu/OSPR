// 初始化的时候加载数据
function loadData(){
	loadProvince();
	loadPro();
}

/*地址数据加载*/
//省份数据加载
function loadPro(){
	// 加载省份
	var saveProvince = ["浙江省","广东省","山东省","江苏省","福建省","甘肃省"];
	// 获取指定的表单中的下拉列表
	var province = document.forms["studentInfo"].studentPro;
	// 依次加载数据
	for(var i=0;i<saveProvince.length;i++){
		// 创建新的节点并设置相关的属性，挂载节点到指定的位置
		var op = document.createElement("option");
		op.value = saveProvince[i];
		op.textContent = saveProvince[i];
		province.appendChild(op);
	}
}

// 获取住址相应的城市
function getProCity(){
	// 获取指定的表单
	var form = document.forms["studentInfo"];
	// 1.获取当前用户选择的省份的索引号(注意索引号要与数组下标一一对应)
	var selectProvinceIndex = form.studentPro.selectedIndex-1;
	var selectProvinceCity = saveCity[selectProvinceIndex];
	// 2.获取城市信息，对城市进行刷新（先清空数据，后添加数据）
	var city = form.studentProCity;
	// 清空数据，保留第一行
	city.length = 1;
	// 3.根据索引查找的城市信息依次添加数据
	for(var i=0;i<selectProvinceCity.length;i++){
		var newOption = new Option(selectProvinceCity[i],selectProvinceCity[i]);
		city[city.length] = newOption;
	}
}

/************************************************************************************/

	
		// 学校数据加载
		function loadProvince(){
			// 加载省份
			var saveProvince = ["浙江省","广东省","山东省","江苏省","福建省","甘肃省"];
			// 获取指定的表单中的下拉列表
			var province = document.forms["studentInfo"].province;
			// 依次加载数据
			for(var i=0;i<saveProvince.length;i++){
				// 创建新的节点并设置相关的属性，挂载节点到指定的位置
				var op = document.createElement("option");
				op.value = saveProvince[i];
				op.textContent = saveProvince[i];
				province.appendChild(op);
			}
		}
	/*将每个省份对应的城市用二维数组进行联系*/
		var saveCity = [
			["杭州市","温州市","宁波市","嘉兴市"],
			["广州市","深圳市","惠州市","潮州市"],
			["济南市","青岛市","潍坊市","济宁市"],
			["南京市","苏州市","南通市","常州市"],
			["厦门市","福州市","龙岩市","福安市"],
			["兰州市","敦煌市","定西市","白银市"]
		];
		/*当选择了相应的省份相应修改城市选择*/
		function getCity(){
			// 获取指定的表单
			var form = document.forms["studentInfo"];
			// 1.获取当前用户选择的省份的索引号(注意索引号要与数组下标一一对应)
			var selectProvinceIndex = form.province.selectedIndex-1;
			var selectProvinceCity = saveCity[selectProvinceIndex];
			// 2.获取城市信息，对城市进行刷新（先清空数据，后添加数据）
			var city = form.city;
			var university = form.college;
			// 清空数据，保留第一行
			city.length = 1;
			university.length=1;
			// 3.根据索引查找的城市信息依次添加数据
			for(var i=0;i<selectProvinceCity.length;i++){
				var newOption = new Option(selectProvinceCity[i],selectProvinceCity[i]);
				city[city.length] = newOption;
			}
		}
		
		/*将每个大学与城市相对应*/
		var college = [
			[
				["浙江大学","杭州电子科技大学","浙江工业大学","浙江理工大学","中国计量大学"],
				["温州医科大学","温州大学","温州商学院","温州科技职业学院"],
				["宁波大学","浙江万里学院","宁波工程学院","宁波诺丁汉大学"],
				["嘉兴学院","嘉兴学院南湖学院","浙江财经大学东方学院","同济大学浙江学院"]
			],
			[
				["中山大学","广东外语外贸大学","广州中医药大学","华南理工大学大学","广东工业大学","广州中医药大学"],
				["深圳大学","南方科技大学","香港中文大学(深圳)","深圳北理莫斯科大学","暨南大学（深圳）"],
				["惠州经济职业技术学院 ","惠州卫生职业技术学院","惠州城市职业学院 "],
				["韩山师范学院","潮州中南科技专修学院","潮州广播电视大学","潮州师范学院"]
			],
			[
				["山东建筑大学","齐鲁工业大学 ","山东中医药大学","山东师范大学","山东体育学院"],
				["中国海洋大学","中国石油大学","青岛理工大学","青岛滨海学院","青岛工学院"],
				["潍坊医学院 ","潍坊学院","潍坊科技学院 "],
				["曲阜师范大学","济宁医学院","山东理工大学","济宁职业技术学院"]
			],
			[
				["东南大学","南京农业大学","中国药科大学","南京航空航天大学","南京工业大学","南京医科大学 "],
				["苏州大学"," 苏州科技大学 ","苏州广播电视大学（苏州职工大学）"],
				["南通大学 ","南通大学杏林学院","南通市工人业余大学 "],
				["河海大学","常州大学","常州工学院","江苏技术师范学院"]
			],
			[
				["厦门大学 ","集美大学","华侨大学厦门校区","厦门理工学院","武汉理工大学厦门学院"],
				["福州大学 ","福建农林大学"," 福建江夏学院","福建警察学院"],
				["龙岩学院 ","闽西职业技术学院","龙岩技师学院 "],
				["福安学院","宁德市职业技术学院"]
			],
			[
				["兰州大学 ","兰州理工大学","兰州交通大学","兰州商学院","甘肃政法学院","甘肃联合大学"],
				["西北师范大学 "],
				["定西师范高等专科学校 "],
				["白银高等职业职工大学","白银市工业学校"]
			],
		];
		/*当选择了相应的城市相应修改大学选择*/
		function getCollege(){
			// 获取指定的表单
			var form = document.forms["studentInfo"];
			// 1.获取当前用户选择的省份、城市的索引号(注意索引号要与数组下标一一对应)
			var selectProvinceIndex = form.province.selectedIndex-1;
			var selectCityIndex = form.city.selectedIndex -1;
			
			// 根据选择省份索引获取省份对应的城市信息
			var currentCity = college[selectProvinceIndex];
			// 根据选择的城市索引获取对应的学校信息
			var currentCollege = currentCity[selectCityIndex];
			
			// 2.获取大学信息，对大学进行刷新（先清空数据，后添加数据）
			var university = form.college;
			
			// 清空数据，保留第一行
			university.length = 1;
			// 3.根据索引查找的学校信息依次添加数据
			for(var i=0;i<currentCollege.length;i++){
				var newOption = new Option(currentCollege[i],currentCollege[i]);
				university[university.length] = newOption;
			}
		}
		
		
		// 根据提交的数据进行字符串的拼接
		/**
		 * 定义表单提交的时候触犯的方法
		 * 处理数据：年月日拼接、preference数据转化为字符串
		 * 利用dom的相关知识点插入两个节点，设置相应的属性，供
		 * 相应的servlet进行访问
		 */
		function doSubmit(){
			makeSchool();
		}
		
		function makeSchool(){
			 var province =document.getElementById("province").value;
			 var city =document.getElementById("city").value;
			 var college=document.getElementById("college").value;
			 var school =province+"-"+city+"-"+college;
			 // 创建节点
			 var input =document.createElement("input");//<input/>
			 input.type="hidden";
			 input.name="studentSchool";
			 input.value=school; //<input type="hidden" value="......"/>
			 
			 alert(school);

			 // 插入节点
			 document.getElementById("studentInfo").appendChild(input);
		}
		
		
