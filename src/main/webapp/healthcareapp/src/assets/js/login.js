function expand(lbl){
  var elemId = lbl.getAttribute("for");
  document.getElementById(elemId).style.height = "45px";
  document.getElementById(elemId).classList.add("my-style");
  lbl.style.transform = "translateY(-45px)";
}
