const pictureadd=document.querySelector(".picture .add");
const pictureshow=document.querySelector(".picture .show");

pictureadd.addEventListener('click',function(){
    console.log("点击了add")
    document.getElementById("fileinput").click();
    // inputfile.click();
});


function changeToop(){
    var file = getId("fileinput");
    if(file.value==''){
      //设置默认图片
    Id("myimg").src='http://sandbox.runjs.cn/uploads/rs/72/huvtowwn/zanwu.png';
    }else{
      preImg("fileinput","myimg");
    }
  }

  //获取input[file]图片的url Important
function getFileUrl(fileId) {
    var url;
    var file = getId(fileId);
    var agent = navigator.userAgent;
    if (agent.indexOf("MSIE")>=1) {
    url = file.value;
    } else if(agent.indexOf("Firefox")>0) {
    url = window.URL.createObjectURL(file.files.item(0));
    } else if(agent.indexOf("Chrome")>0) {
    url = window.URL.createObjectURL(file.files.item(0));
    }
    console.log("得到的文件值"+file.value);
    return url;
  }

  function getId(documentId){
      return document.getElementById(documentId);
  }

  //读取图片后预览
function preImg(fileId,imgId) {
    var imgPre =getId(imgId);
    pictureadd.style.display="none";
    pictureshow.style.display="block";
    imgPre.src = getFileUrl(fileId);
    }