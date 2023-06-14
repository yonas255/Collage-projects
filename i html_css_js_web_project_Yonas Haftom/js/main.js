
/*
1.Browser plug-in detection

*******************************************************************
Script 1: Browser Plugin Detection (browserdetection.html)
this function detects the user browser
******************************************************************
*/
function browserDetection() { 
	if(navigator.userAgent.indexOf("Chrome") != -1 ){
		document.getElementById("browser").innerHTML=" <p>Your browser is Chrome</p>";
    }
    else if(navigator.userAgent.indexOf("Opera") != -1 ){
		document.getElementById("browser").innerHTML="OPERA";
    }
    else if(navigator.userAgent.indexOf("Firefox") != -1 ){
       document.getElementById("browser").innerHTML=" FIREFOX";
    }
    else if((navigator.userAgent.indexOf("MSIE") != -1 ) || (!!document.documentMode == true )){
      document.getElementById("browser").innerHTML="Internet";
    }  
    else{
       document.getElementById("browser").innerHTML="Unknown";
    }
}// end function browserDetection
/*
******************************************************************
Script 2: Status Bar Message (statusbar.html)
this function shows a message on the status bar
******************************************************************
*/

function statusBar() {
  var elem = document.getElementById("myBar");  
  elem.style.display = 'block';
  elem.style.color = 'white';
  elem.style.backgroundColor='black';
  var width = 1;
  var id = setInterval(frame, 10);
  function frame() {
    if (width >= 100) {
	elem.style.color = 'aqua';
      clearInterval(id);
	  alert('we have recieved the message and we will contact you soon');
	  elem.style.display='none';
	  
    } else {
      width++;
      elem.style.width = width + '%';
	  elem.textContent = width + '%';
	  
    }
	
  }
} // End function


/*
/*
/*****************************************************************
Script3 :  Scrolling Text( scrolltext.html)
this function is used for  Scrolling Text
****************************************************************
*/
var message = "Good Afternoon Wellcome to my Web Page";
i=0;
function scrollBox() {
	i++;
	if(i > message.length) {
	    i = 1;
	}
	document.forms[0].elements[0].value = message.substring(0,i)+"_";
	setTimeout("scrollBox()",130);
}//end function scrollBox

/*
/*****************************************************************
Script 4: Text Rollover (textrollover.html)
this function is used for a text rollover
****************************************************************
*/
function mouseOver() {
    document.getElementById("mytext").style.color = "#f9004d";
}// end function

function mouseOut() {
    document.getElementById("mytext").style.color = "white";
}// end function

/*
Script 5: Cycling Animations (cyclinganimations.html)
Using Canvas
******************************************************************
*/
//declare variables
var img = new Image();
img.src = 'img/air.jpeg';
var CanvasXSize = 1125;
var CanvasYSize = 250;
var speed = 20; //lower is faster
var scale = 1.05;
var y = -4.5; //vertical offset

// Main program
var dx = 0.90;
var imgW;
var imgH;
var x = 0;
var clearX;
var clearY;
var ctx;

img.onload = function() {
    imgW = img.width*scale;
    imgH = img.height*scale;
    if (imgW > CanvasXSize) { 
		x = CanvasXSize-imgW; 
    } // image larger than canvas
    if (imgW > CanvasXSize) { 
		clearX = imgW; 
	} // image larger than canvas
    else { 
		clearX = CanvasXSize; 
	}
    if (imgH > CanvasYSize) { 
		clearY = imgH; 
	} // image larger than canvas
    else {
		clearY = CanvasYSize; 
	}
    //Get Canvas Element
    ctx = document.getElementById('canvas').getContext('2d');
    //Set Refresh Rate
    return setInterval(draw, speed);
}

function draw() {
	//Clear Canvas
    ctx.clearRect(0,0,clearX,clearY);
    //If image is <= Canvas Size
    if (imgW <= CanvasXSize) {
        //reset, start from beginning
        if (x > (CanvasXSize)) {
			x = 0; 
		}
        //draw aditional image
        if (x > (CanvasXSize-imgW)) {
			ctx.drawImage(img,x-CanvasXSize+1,y,imgW,imgH); 
		}
    }
    //If image is > Canvas Size
    else {
        //reset, start from beginning
        if (x > (CanvasXSize)) { 
			x = CanvasXSize-imgW; 
		}
        //draw aditional image
        if (x > (CanvasXSize-imgW)) { 
			ctx.drawImage(img,x-imgW+1,y,imgW,imgH);			
	    }
    }
    //draw image
    ctx.drawImage(img,x,y,imgW,imgH);
    //amount to move
    x += dx;
}// end function draw



 /*
*******************************************************
Script 6: Slide Show (slideshow2.html)
***********************************************************
*/

var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}

// end function slideShow
/*
*******************************************************
Script 7:Dynamic Frame Update(dynamicframesupdate.html)
this function changes the content of an iframe
***********************************************************
*/
function dynamicFrame() {
    var frames = window.frames;
	frames[0].location = "https://www.ai.nl/artificial-intelligence/timeline-of-ai-a-brief-history-of-artificial-intelligence-its-highlights/";
}// end dynamicFrame

/*
/*****************************************************************
Script 8: Email Verification(emailverification.html and emailthanks.html)
this function is used for email verification
****************************************************************
*/
function validateEmail(emailField){ 

        var reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/; 

        if (reg.test(emailField.value) == false)  

        { 

            alert('Invalid Email Address'); 

            return false; 

        } 



} //end function emailVerification 


/*****************************************************************
Script 9: New Window  (newwindow.html)
****************************************************************
*/
function newWindow() {
    window.open("https://www.hpe.com/uk/en/solutions/artificial-intelligence/nvidia-collaboration.html?jumpid=ps_u1b8kkh4m_aid-520061736&ef_id=2905ab3f06d81447b7b0c88ac48a8221:G:s&s_kwcid=AL!13472!10!81432696008308!81432846220230&msclkid=2905ab3f06d81447b7b0c88ac48a8221");
}//end newWindow

/*
/*****************************************************************
Script 10: Set Cookie and Return Cookie (cookie.html)
these two functions setting and returning a cookie
****************************************************************
*/
//function number 16
//setting and getting cookies all are in contact us page

function writeCookie() {
  if (document.myform.customer.value == "") {
      alert("Enter some value!");
      return;
  }
  cookievalue = escape(document.myform.customer.value) + "";
  document.cookie = "name=" + cookievalue;
  alert("Setting Cookies : " + "name=" + cookievalue);
}

//end function write cookie 

//===================================

//start function get cookie 
//function number 17

function readCookie() {

  document.getElementById("cookie").innerHTML = "Your cookie is " + cookievalue;

}


/*******************************************************
Script 11:Dynamic Web Page Update(Time)(dynamicwebpageupdate.html)
this function prints the time
***********************************************************
*/
function timeDigtal(){
	var currentTime = new Date();
	var hours = currentTime.getHours();
	var minutes = currentTime.getMinutes();
	var seconds = currentTime.getSeconds();
    document.getElementById("digtime").innerHTML="<p>Time is: " + hours + ":" + minutes + " " + ":" + seconds + " " + "</p>";
}//end function timeDigtal

/*
*******************************************************
Script 12:Hit Page Counter(hitcounter.html)
this function prints the time
***********************************************************
*/

function hitCount(){
	if (localStorage.pagecount){
		localStorage.pagecount=Number(localStorage.pagecount) +1;
	}
	else{
		localStorage.pagecount=1;
	}
	document.getElementById("hits").innerHTML= "<p>Visits to site: " + localStorage.pagecount; "</p>"
}//end hitCount
