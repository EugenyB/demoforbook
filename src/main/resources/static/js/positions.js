
let myAddPositionDialog = document.getElementById("add_position");
myAddPositionDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    let form = document.getElementById("add_position_form");
    form.setAttribute('action', link);
    let title = button.getAttribute('data-bs-title');

    let approveButton = document.getElementById("approve_position");
    let titleEdit = document.getElementById("position_title");
    let idField = document.getElementById("position_id");

    let dialogTitle = myAddPositionDialog.querySelector('.modal-title');
    if (button.getAttribute('data-bs-ident') === '#add') {
        idField.value = '0';
        titleEdit.value = '';

        approveButton.textContent = "Add Position";
        dialogTitle.textContent = "Add Position";
    } else {
        idField.value = button.getAttribute('data-bs-id');
        titleEdit.value = title;

        dialogTitle.textContent = "Edit Position";
        approveButton.textContent = "Update Position";
    }
});