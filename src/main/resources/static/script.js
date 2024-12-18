const inputForm = document.getElementById("form");
if (inputForm) {console.log("form kopplad");}
const editBtn = document.getElementById("editBtn");
if (editBtn) {console.log("btn kopplad");}
const pTaggRubrik = document.getElementById("rubrik");
if (pTaggRubrik) {console.log("ptaggRubrik kopplad");}
const pTaggText = document.getElementById("text");
if (pTaggText) {console.log("ptaggText kopplad");}
let inputRubrik = document.getElementById("editRubrik");
if (inputRubrik) {console.log("inputRubrik kopplad");}
let inputText = document.getElementById("editText");
if (inputText) {console.log("inputText kopplad");} // ta bort alla if på slutet
const currentDate = document.getElementById("editDate");

editBtn.addEventListener("click", () => {
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