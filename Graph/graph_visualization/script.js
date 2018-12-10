var clickHistory = [];
var progress;

var breadth_interval;
var depth_interval;

function setup() { //initialize everything
  fillFunctionButtons();
  fillStatusText();
  //fillProgressBar();
  fillMatrix();
  setStatusText("Loaded succesfully!", "text-bold" );

  setButtonColor(7, 0, "yellow");
  setButtonColor(0, 7, "red");  //goal
  makeHorizontalWall(1, 1, 7);
  makeHorizontalWall(3, 1, 4);
  makeHorizontalWall(5, 0, 4);
  makeHorizontalWall(7, 1, 6);

  //makeVerticalWall(4, 4, 4);
  makeVerticalWall(6, 3, 6);

}

//this is what's triggered when any button in the matrix is pressed

function buttonClicked(i, j) { //this is where you should start
  setStatusText("Button [" + i + ", " + j + "] pressed");



  // clickHistory.push(i*8 + j);
  //set this button to a random color
  // setButtonColor(i, j, getRandomColor());
  // var currentText = getButtonText(i, j);
  // var textValue = 0;
  // if (currentText != "") {
  //   textValue = parseInt(currentText, 10); //convert the text to base10 (decimal) number
  // }
  // setButtonText(i, j, textValue+1);
  //increase the progress bar a bit
  // progress += textValue;
  // setProgressBar("bar", "bg-success", progress);
}


function makeHorizontalWall(i, start_j, end_j){
  for(var index = start_j; index <= end_j; index++){
    setButtonColor(i, index, 'gray');
  }
}

function makeVerticalWall(j, start_i, end_i){
  for(var index = start_i; index <= end_i; index++){
    setButtonColor(index, j, 'gray');
  }
}


function breadthFirstSearch(){
  var start_ij = "7_0";

  var queue = new Queue();
  queue.enqueue(start_ij);

  breadth_interval = setInterval(breadth_search,100);

  function breadth_search(){
    if(!queue.isEmpty()){
      var currPair = queue.dequeue();
      var ijArr = currPair.split("_");
      var curr_i = ijArr[0];
      var curr_j = ijArr[1];

      if(getButtonColor(curr_i, curr_j) == "red"){
        alert("found");
        clearInterval(breadth_interval);
      }


      if(getButtonColor(curr_i, curr_j) == "white"){
        setButtonColor(curr_i, curr_j, "yellow");
      }

      var up_ij = (parseInt(curr_i) - 1) + "_" + curr_j;
      var down_ij = (parseInt(curr_i) + 1) + "_" + curr_j;
      var left_ij = curr_i + "_" + (parseInt(curr_j) - 1);
      var right_ij = curr_i + "_" + (parseInt(curr_j) + 1);

      var directions = [up_ij, right_ij, down_ij, left_ij];

      for(var index = 0; index < 4; index++){
        var curr_ij = directions[index];
        var directionsButton = document.getElementById("img_" + curr_ij);
        if(directionsButton == null) continue;
        if(directionsButton.getAttribute("alt") == "white" || directionsButton.getAttribute("alt") == "red"){
          queue.enqueue(curr_ij);
        }
      }
    }else{
      clearInterval(interval);
    }
    


  }

}


function depthFirstSearch(ij){
  var start_ij = "7_0";

  depth_interval = setInterval(depth_search,100);

  function depth_search(){
    if(!queue.isEmpty()){
      var currPair = queue.dequeue();
      var ijArr = currPair.split("_");
      var curr_i = ijArr[0];
      var curr_j = ijArr[1];

      if(getButtonColor(curr_i, curr_j) == "red"){
        alert("found");
        clearInterval(depth_interval);
      }


      if(getButtonColor(curr_i, curr_j) == "white"){
        setButtonColor(curr_i, curr_j, "yellow");
      }

      var up_ij = (parseInt(curr_i) - 1) + "_" + curr_j;
      var down_ij = (parseInt(curr_i) + 1) + "_" + curr_j;
      var left_ij = curr_i + "_" + (parseInt(curr_j) - 1);
      var right_ij = curr_i + "_" + (parseInt(curr_j) + 1);

      var directions = [up_ij, right_ij, down_ij, left_ij];

      for(var index = 0; index < 4; index++){
        var curr_ij = directions[index];
        var directionsButton = document.getElementById("img_" + curr_ij);
        if(directionsButton == null) continue;
        if(directionsButton.getAttribute("alt") == "white" || directionsButton.getAttribute("alt") == "red"){
          queue.enqueue(curr_ij);
        }
      }
    }else{
      clearInterval(interval);
    }
    


  }

}






function fillFunctionButtons() {
  var headDiv = document.getElementById("head");
  var funcBtnRow = createRow();
  // createButton(buttonText, styleClass, functionName);
  funcBtnRow.appendChild(createButton("Breadth First Search", "btn btn-primary btn-sm m-3", "breadthFirstSearch()"));
  funcBtnRow.appendChild(createButton("Depth First Search", "btn btn-primary btn-sm m-3", "depthFirstSearch('7_0')"));
  funcBtnRow.appendChild(createButton("Defile", "btn btn-dark btn-sm m-3", "f3()"));
  funcBtnRow.appendChild(createButton("Puuurrrge!", "btn btn-light m-3", "f4()"));
  headDiv.appendChild(funcBtnRow);
}


function fillMatrix() {
  var matrix = document.getElementById("grid");
  for (i = 0; i < 8; i++) {
    var newRow = createRow("justify-content-md-center");
    for (j = 0; j < 8; j++) {
      newRow.appendChild(createDefaultButton(i, j));
    }
    matrix.appendChild(newRow);
  }
}





// helper functions below

function createRow(className) {
  var rowDiv = document.createElement("div");
  if (className == null) {
    rowDiv.className = "row";
  } else {
    rowDiv.className = "row " + className;
  }
  return rowDiv;
}

function createButton(buttonText, styleClass, functionName) {
  var button = document.createElement("button");
  button.className = styleClass;
  button.appendChild(document.createTextNode(buttonText));
  button.setAttribute("onclick", functionName);
  return button;
}



function createDefaultButton() {
  var button = document.createElement("div");
  button.className = "thumbnail";
  button.setAttribute("onclick", "buttonClicked("+i+","+j+")");

  //the image part
  var img = document.createElement("img");
  img.id = "img_" + i + "_" + j;
  img.setAttribute("src", "images/white.jpg");
  img.setAttribute("alt", "white");
  //img.setAttribute("class", "rounded-circle");
  img.setAttribute("width", "75");
  img.setAttribute("height", "75");
  img.setAttribute("style","border: 1px solid black");

  //the text part
  var text = document.createElement("label");
  text.setAttribute("class", "caption unselectable");
  text.id = "text_" + i + "_" + j;

  button.appendChild(img);
  button.appendChild(text);
  return button;
}

function setButtonColor(i, j, color) {
  var button = document.getElementById("img_" + i + "_" + j);
  if(button == null) return;
  button.setAttribute("src", "images/" + color + ".jpg");
  button.setAttribute("alt", color);
}

function setButtonText(i, j, text) {
  var button = document.getElementById("text_" + i + "_" + j);
  button.innerHTML = text;
}

function getButtonColor(i, j) {
  var img = document.getElementById("img_" + i + "_" + j);
  if(img == null) return null;
  return img.getAttribute("alt");
}

function getButtonText(i, j) {
  var text = document.getElementById("text_" + i + "_" + j);
  return text.innerHTML;
}














/////////////////     unused     ////////////////



function getRandomColor() {
  //you might want to change this to get more colors
  var random = Math.floor(Math.random() * 4);
  if (random < 1) {
    return "red";
  } else if (random < 2) {
    return "green";
  } else if (random < 3) {
    return "turquoise";
  }
  return "yellow";
}

function getRandomNumber(min, max) {
  return min + Math.floor(Math.random() * (max - min + 1));
}

//console interaction functions
function logAllHistory() {
  if (clickHistory.length == 0) {
    console.log("History is empty");
    return;
  }
  for (i = 0; i < clickHistory.length; i++) {
    console.log(clickHistory[i]);
  }
}

function logLastClicked() {
  if (clickHistory.length == 0) {
    console.log("History is empty");
  } else {
    console.log(clickHistory[clickHistory.length - 1]);
  }
}

function fillStatusText() {
  var headDiv = document.getElementById("head");
  var infoTextRow = createRow("ml-3");
  infoTextRow.id = "infoText"; //set id of this element so we can change it later
  headDiv.appendChild(infoTextRow);
}

function setStatusText(text, style) {
  var textDiv = document.getElementById("infoText");
  var newText = document.createElement("p");
  if (style != null) {
    newText.className = style;
  }
  newText.appendChild(document.createTextNode(text));
  textDiv.innerHTML = "";
  textDiv.appendChild(newText);
}

function fillProgressBar() {
  var headDiv = document.getElementById("head");
  var progessRow = createRow("progress");
  progress = 0;
  //a green colored bar
  var bar = createProgressBar("bar", "bg-success", progress);
  progessRow.appendChild(bar);
  headDiv.appendChild(progessRow);
}



function fillAllRandom() { //sample function 1
  for (i = 0; i < 8; i++) {
    for (j = 0; j < 8; j++) {
      setButtonColor(i, j, getRandomColor());
      setButtonText(i, j, getRandomNumber(1, 10));
    }
  }
}

function drop() { //sample function 2
  for (i = 7; i > 0; i--) {
    for (j = 0; j < 8; j++) {
      setButtonColor(i, j, getButtonColor(i-1, j));
      setButtonText(i, j, getButtonText(i-1, j));
    }
  }
  //for row 0
    for (j = 0; j < 8; j++) {
      setButtonColor(i, j, getRandomColor());
      setButtonText(i, j, getRandomNumber(1, 10));
    }
}

function defile(number) { //sample function 3 (recursion and time)
  if (number < 0) return;
  for (n = 0; n < number; n++) {
    setTimeout(function(){
      var i = getRandomNumber(0, 7);
      var j = getRandomNumber(0, 7);
      setButtonColor(i, j, "black");
      setButtonText(i, j, "");
      setProgressBar("bar", "bg-danger", progress--);
    }, (number+1)*number - n*n);
  }
}

function purge() { //sample function 4
  for (i = 0; i < 8; i++) {
    for (j = 0; j < 8; j++) {
      setButtonColor(i, j, "white");
      setButtonText(i, j, "");
    }
  }
  progress = 0;
  clickHistory = [];
  setProgressBar("bar", "bg-success", progress);
}

function f1() {
  setStatusText("Fill with random colors");
  fillAllRandom();
}

function f2() {
  setStatusText("Drop everything by 1 row");
  drop();
}

function f3() {
  setStatusText("BAM! BAM! BAM!");
  defile(32);
}

function f4() {
  setStatusText("Reset EVERYTHING");
  purge();
}

function createProgressBar(bar_id, color, value) {
  var bar = document.createElement("div");
  bar.id = bar_id;
  bar.className = "progress-bar " + color;
  bar.setAttribute("style", "width: " + value + "%");
  return bar;
}

function setProgressBar(bar_id, color, value) {
  var bar = document.getElementById(bar_id);
  bar.className = "progress-bar " + color;
  bar.setAttribute("style", "width: " + value + "%");
  bar.innerHTML = value + "%";
}


