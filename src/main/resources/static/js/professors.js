let editProfessorDialog = document.getElementById("add_professor");
editProfessorDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    document.getElementById("add_professor_form").setAttribute('action', link);

    let posList = document.getElementById("prof_positions");
    let deptList = document.getElementById("prof_departments");
    let modalTitle = document.getElementById('staticEditLabel');
    let confirmButton = editProfessorDialog.querySelector('.change-button');

    if (button.getAttribute('data-bs-ident') === '#edit') {
        let pid = button.getAttribute('data-bs-id');
        let firstName = button.getAttribute('data-bs-first-name');
        let lastName = button.getAttribute('data-bs-last-name');
        let degree = button.getAttribute('data-bs-degree');
        let pos_id = button.getAttribute('data-bs-pos-id');
        let dept_id = button.getAttribute('data-bs-dept-id');

        document.getElementById("prof_first_name").setAttribute('value', firstName);
        document.getElementById("prof_last_name").setAttribute('value', lastName);
        document.getElementById("prof_degree").setAttribute('value', degree);

        modalTitle.textContent = 'Edit: ' + firstName + ' ' + lastName + ' (' + pid + ')';

        document.getElementById("prof_id").setAttribute('value', pid);
        document.getElementById("prof_first_name").setAttribute('value', firstName);
        document.getElementById("prof_last_name").setAttribute('value', lastName);
        document.getElementById("prof_degree").setAttribute('value', degree);

//    if we want to select the option with the given value
        for (let i = 0; i < posList.options.length; i++) {
            posList.options[i].selected = (posList.options[i].value === pos_id);
        }
        for (let i = 0; i < deptList.options.length; i++) {
            deptList.options[i].selected = (deptList.options[i].value === dept_id);
        }

        confirmButton.setAttribute('value', 'Update');
    }  else {
        document.getElementById("prof_id").setAttribute('value', '0');
        document.getElementById("prof_first_name").setAttribute('value', '');
        document.getElementById("prof_last_name").setAttribute('value', '');
        document.getElementById("prof_degree").setAttribute('value', '');
        document.getElementById("prof_positions").selectedIndex = 0;
        document.getElementById("prof_departments").selectedIndex = 0;
        modalTitle.textContent = 'Add Professor';
        confirmButton.setAttribute('value', 'Add');
    }
});