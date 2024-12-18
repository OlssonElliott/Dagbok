const inputForm = document.getElementById("form");
const editBtn = document.getElementById("editBtn");
const pTaggRubrik = document.getElementById("rubrik");
const pTaggText = document.getElementById("text");

let inputRubrik = document.getElementById("editRubrik");
let inputText = document.getElementById("editText");

editBtn.addEventListener("click", () => { //togglar dold/inte dold för redigering samt överför innehåll från input text till textfield
    inputRubrik.value = pTaggRubrik.textContent;
    inputText.value = pTaggText.textContent;
    if (inputForm.style.display === "none"){
        pTaggRubrik.style.display = "none";
        pTaggText.style.display = "none";
        inputForm.style.display = "block";
    }
    else {
        pTaggRubrik.style.display = "block";
        pTaggText.style.display = "block";
        inputForm.style.display = "none";
    }

})