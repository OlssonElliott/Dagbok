const inputForm = document.getElementById("form");
const editBtn = document.getElementById("editBtn");
const pTaggRubrik = document.getElementById("rubrik");
const pTaggText = document.getElementById("text");
let inputRubrik = document.getElementById("editRubrik");
let inputText = document.getElementById("editText");

editBtn.addEventListener("click", () => {
    
    inputRubrik.value = pTaggRubrik.textContent;
    inputText.value = pTaggText.textContent;
    console.log(inputRubrik.value + inputText.value);

    pTaggRubrik.style.display = "none";
    pTaggText.style.display = "none";
    inputForm.style.display = "block";

})