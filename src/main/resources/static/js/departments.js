
let myAddDeptDialog = document.getElementById("add_dept");
myAddDeptDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    let form = document.getElementById("add_dept_form");
    form.setAttribute('action', link);
    let name = button.getAttribute('data-bs-name');

    let approveButton = document.getElementById("approve_dept");
    let nameEdit = document.getElementById("dept_name");
    let idField = document.getElementById("dept_id");

    let dialogTitle = myAddDeptDialog.querySelector('.modal-title');
    if (button.getAttribute('data-bs-ident') === '#add') {
        idField.value = '0';
        nameEdit.value = '';

        approveButton.textContent = "Add Department";
        dialogTitle.textContent = "Add Department";
    } else {
        idField.value = button.getAttribute('data-bs-id');
        nameEdit.value = name;

        dialogTitle.textContent = "Edit Department";
        approveButton.textContent = "Update Department";
    }
});