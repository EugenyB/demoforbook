let editGroupDialog = document.getElementById("add_group");
editGroupDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    document.getElementById("add_group_form").setAttribute('action', link);

    let majList = document.getElementById("group_majors");
    let deptList = document.getElementById("group_departments");
    let curatorList = document.getElementById("group_curators");
    let modalTitle = document.getElementById('staticEditLabel');
    let confirmButton = editGroupDialog.querySelector('.change-button');

    if (button.getAttribute('data-bs-ident') === '#edit') {
        let gid = button.getAttribute('data-bs-id');
        let name = button.getAttribute('data-bs-name');
        let major_id = button.getAttribute('data-bs-maj-id');
        let dept_id = button.getAttribute('data-bs-dept-id');
        let curator_id = button.getAttribute('data-bs-prof-id');
        document.getElementById("group_name").setAttribute('value', name);
        modalTitle.textContent = 'Edit: ' + name + ' ' + ' (' + gid + ')';

        document.getElementById("group_id").setAttribute('value', gid);

        document.getElementById("group_name").setAttribute('value', name);

//    if we want to select the option with the given value
        for (let i = 0; i < majList.options.length; i++) {
            majList.options[i].selected = (majList.options[i].value === major_id);
        }
        for (let i = 0; i < deptList.options.length; i++) {
            deptList.options[i].selected = (deptList.options[i].value === dept_id);
        }
        for (let i = 0; i < curatorList.options.length; i++) {
            curatorList.options[i].selected = (curatorList.options[i].value === curator_id);
        }
        // document.getElementById("add_group_form").setAttribute('method', 'PATCH')

        confirmButton.setAttribute('value', 'Update');
    }  else {
        // document.getElementById("add_group_form").setAttribute('method', 'PUT')
        document.getElementById("group_id").setAttribute('value', '0');
        document.getElementById("group_name").setAttribute('value', '');
        document.getElementById("group_majors").selectedIndex = 0;
        document.getElementById("group_departments").selectedIndex = 0;
        document.getElementById("group_curators").selectedIndex = 0;
        modalTitle.textContent = 'Add Group';
        confirmButton.setAttribute('value', 'Add');
    }
});