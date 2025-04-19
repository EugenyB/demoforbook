let setHeadForDeptDialog = document.getElementById("add_set_head");
setHeadForDeptDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    let did = button.getAttribute('data-bs-did');
    let name = button.getAttribute('data-bs-name');
    let hid = button.getAttribute('data-bs-hid');
    let list = setHeadForDeptDialog.querySelector(".form-control");

    // let modalTitle = myConfirmDialog.querySelector('.modal-title');
    let modalTitle = document.getElementById('staticChooseLabel');
    modalTitle.textContent  = 'Head for Dept: ' + name + ' (' + did + ')';
    // let modalText = setHeadForDeptDialog.querySelector('.modal-text');
    // modalText.textContent  = name + ' (' + did + ')';

    for (let i = 0; i < list.options.length; i++) {

        list.options[i].selected = (list.options[i].value === hid);
    }
    document.getElementById("did").setAttribute('value', did);
    // let confirmButton = setHeadForDeptDialog.querySelector('.confirm-button');
    // confirmButton.setAttribute('href', link)
});