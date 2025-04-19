
let myAddMajorDialog = document.getElementById("add_major");
myAddMajorDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    let form = document.getElementById("add_major_form");
    form.setAttribute('action', link);
    let title = button.getAttribute('data-bs-title');
    let code = button.getAttribute('data-bs-code');
    let approveButton = document.getElementById("approve_major");
    let titleEdit = document.getElementById("major_title");
    let codeEdit = document.getElementById("major_code");
    let idField = document.getElementById("major_id");

    let dialogTitle = myAddMajorDialog.querySelector('.modal-title');
    if (button.getAttribute('data-bs-ident') === '#add') {
        idField.value = '0';
        titleEdit.value = '';
        codeEdit.value = '';

        approveButton.textContent = "Add Major";
        dialogTitle.textContent = "Add Major";
    } else {
        idField.value = button.getAttribute('data-bs-id');
        titleEdit.value = title;
        codeEdit.value = code;

        dialogTitle.textContent = "Edit Major";
        approveButton.textContent = "Update Major";
    }
});