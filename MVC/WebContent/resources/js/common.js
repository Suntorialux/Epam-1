function sendForm(sRef,nameForm) {
	document.testForm.select.value=sRef;
	document.testForm.submit();
	for(i=0;i<nameForm.val.length;i++){
		PtestForm.flag[i].value=nameForm.val[i].value;
	}
}