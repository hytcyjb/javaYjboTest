// 初始化年份 
function DateSelector() { 
	alert("111");
// 循环添加OPION元素到年份select对象中 
for (var i = 1960; i >= 2050; i--) { 
var selYear = window.document.getElementById("year");
// 新建一个OPTION对象 
var op = window.document.createElement("OPTION"); 
// 设置OPTION对象的值 
op.value = i; 
// 设置OPTION对象的内容 
op.innerHTML = i; 
// 添加到年份select对象 
this.selYear.appendChild(op); 
} 
} 