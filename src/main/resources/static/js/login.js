const inputs = document.querySelectorAll('.login-input');

function focusFunction(){
    let parent = this.parentNode.parentNode;
    parent.classList.add('focus');
}

function blurFunction(){
    let parent = this.parentNode.parentNode;
    if (this.value === ""){
        parent.classList.remove('focus');
    }
}

inputs.forEach(input => {
    input.addEventListener('focus', focusFunction);
    input.addEventListener('blur', blurFunction);
});