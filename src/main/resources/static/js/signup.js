
const email = document.querySelector('#email');
const pwd1 = document.querySelector('#password1');
const pwd2 = document.querySelector('#password2');
const userName = document.querySelector('#name');
const error = document.querySelectorAll('.error-check');
const errorcolor = document.querySelectorAll('.text-field');
const button = document.querySelector('.submit-btn');
button.disabled = true;
var emailOk = false;
var pwd1Ok = false;
var pwd2Ok = false;
var nameOk = false;


email.addEventListener("focus", isEmailCorrect);
email.addEventListener("focusout", isEmailCorrect);
pwd1.addEventListener("focus", checkPw);
pwd1.addEventListener("focusout", checkPw);
pwd2.addEventListener("focus", comparePw);
pwd2.addEventListener("focusout", comparePw);
userName.addEventListener("focus", checkName);
userName.addEventListener("focusout", checkName);


function isEmailCorrect() {
    const emailPattern = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/;
    if(email.value === ""){
        error[0].innerHTML = "* 필수 정보입니다.";
        error[0].style.display = "block";
        errorcolor[0].style.borderColor = "#d32f2f";
        emailOk = false;
        button.disabled = true;
        button.style.opacity = "0.4";
    } else if(!emailPattern.test(email.value)) {
        error[0].innerHTML = "* 이메일 형식으로 적어주세요.";
        error[0].style.display = "block";
        errorcolor[0].style.borderColor = "#d32f2f";
        emailOk = false;
        button.disabled = true;
        button.style.opacity = "0.4";
    } else {
        error[0].style.display = "none";
        errorcolor[0].style.borderColor = "#4caf50"
        emailOk = true;
        isOk = allOk(emailOk, pwd1Ok, pwd2Ok, nameOk);
        if( isOk == true ){
            button.disabled = false;
            button.style.opacity = "1";
            button.style.cursor = "pointer";
            console.log(email.value);
            console.log(pwd1.value);
            console.log(userName.value);
        } 
    }
}

function checkPw() {
    const pwPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
    if(pwd1.value === "") {
        error[1].innerHTML = "* 필수 정보입니다.";
        error[1].style.display = "block";
        errorcolor[1].style.borderColor = "#d32f2f";
        pwd1Ok = false;
        button.disabled = true;
        button.style.opacity = "0.4"
    } else if(!pwPattern.test(pwd1.value)) {
        error[1].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        error[1].style.display = "block";
        errorcolor[1].style.borderColor = "#d32f2f"
        pwd1Ok = false;
        button.disabled = true;
        button.style.opacity = "0.4"
    } else {
        errorcolor[1].style.borderColor = "#4caf50"
        error[1].style.display = "none";
        pwd1Ok = true;
        isOk = allOk(emailOk, pwd1Ok, pwd2Ok, nameOk);
        if( isOk == true ){
            button.disabled = false;
            button.style.opacity = "1";
            button.style.cursor = "pointer";
            console.log(email.value);
            console.log(pwd1.value);
            console.log(userName.value);
        } 
    }
}

function comparePw() {
    if(pwd2.value === pwd1.value) {
        error[2].style.display = "none";
        error[2].innerHTML = "비밀번호가 일치합니다";
        errorcolor[2].style.borderColor = "#4caf50";
        pwd2Ok = true;
        isOk = allOk(emailOk, pwd1Ok, pwd2Ok, nameOk);
        if( isOk == true ){
            button.disabled = false;
            button.style.opacity = "1";
            button.style.cursor = "pointer";
            console.log(email.value);
            console.log(pwd1.value);
            console.log(userName.value);
        } 
    } else if(pwd2.value !== pwd1.value) {
        error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[2].style.display = "block";
        errorcolor[2].style.borderColor = "#d32f2f"
        pwd2Ok = false;
        button.disabled = true;
        button.style.opacity = "0.4";
    }

    if(pwd2.value === "") {
        error[2].innerHTML = "* 필수 정보입니다.";
        error[2].style.display = "block";
        errorcolor[2].style.borderColor = "#d32f2f"
        pwd2Ok = false;
        button.disabled = true;
        button.style.opacity = "0.4";
    }
}

function checkName() {
    const namePattern = /[a-zA-Z가-힣]/;
    if(userName.value === "") {
        nameOk = false;
        error[3].innerHTML = "* 필수 정보입니다.";
        error[3].style.display = "block";
        errorcolor[3].style.borderColor = "#d32f2f";
        button.disabled = true;
        button.style.opacity = "0.4";
    } else if(!namePattern.test(userName.value) || userName.value.indexOf(" ") > -1) {
        nameOk = false;
        error[3].innerHTML = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        error[3].style.display = "block";
        errorcolor[3].style.borderColor = "#d32f2f";
        button.disabled = true;
        button.style.opacity = "0.4";
    } else {
        error[3].style.display = "none";
        errorcolor[3].style.borderColor = "#4caf50";
        nameOk = true;
        isOk = allOk(emailOk, pwd1Ok, pwd2Ok, nameOk);
        if( isOk == true ){
            button.disabled = false;
            button.style.opacity = "1";
            button.style.cursor = "pointer";
            console.log(email.value);
            console.log(pwd1.value);
            console.log(userName.value);
        } 
    }
}

function allOk(ok1, ok2, ok3, ok4) {
    if(ok1 && ok2 && ok3 && ok4) {
        return true;
    } else {
        return false;
    }
}