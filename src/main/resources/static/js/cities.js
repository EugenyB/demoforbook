
let myAddCityDialog = document.getElementById("add_city");
myAddCityDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    let form = document.getElementById("add_city_form");
    form.setAttribute('action', link);
    let name = button.getAttribute('data-bs-name');

    let approveButton = document.getElementById("approve_city");
    let nameEdit = document.getElementById("city_name");
    let idField = document.getElementById("city_id");

    let dialogTitle = myAddCityDialog.querySelector('.modal-title');
    if (button.getAttribute('data-bs-ident') === '#add') {
        idField.value = '0';
        nameEdit.value = '';

        approveButton.textContent = "Add City";
        dialogTitle.textContent = "Add City";
    } else {
        idField.value = button.getAttribute('data-bs-id');
        nameEdit.value = name;

        dialogTitle.textContent = "Edit City";
        approveButton.textContent = "Update City";
    }
});