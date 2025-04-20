let editStudentDialog = document.getElementById("add_student");
editStudentDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    document.getElementById("add_student_form").setAttribute('action', link);

    let citiesList = document.getElementById("student_cities");
    let groupsList = document.getElementById("student_groups");
    let modalTitle = document.getElementById('staticEditLabel');
    let confirmButton = editStudentDialog.querySelector('.change-button');

    if (button.getAttribute('data-bs-ident') === '#edit') {
        let sid = button.getAttribute('data-bs-id');
        let firstName = button.getAttribute('data-bs-first-name');
        let lastName = button.getAttribute('data-bs-last-name');
        let birthday = button.getAttribute('data-bs-birthday');
        let address = button.getAttribute('data-bs-address')
        let city_id = button.getAttribute('data-bs-city-id');
        let group_id = button.getAttribute('data-bs-group-id');

        document.getElementById("student_id").setAttribute('value', sid);
        document.getElementById("student_first_name").setAttribute('value', firstName);
        document.getElementById("student_last_name").setAttribute('value', lastName);
        document.getElementById("student_birthday").setAttribute('value', birthday);

        modalTitle.textContent = 'Edit: ' + firstName + ' ' + lastName + ' (' + sid + ')';

        document.getElementById("student_birthday").setAttribute('value', birthday);
        document.getElementById("student_address").setAttribute('value', address);

//    if we want to select the option with the given value
        for (let i = 0; i < citiesList.options.length; i++) {
            citiesList.options[i].selected = (citiesList.options[i].value === city_id);
        }
        for (let i = 0; i < groupsList.options.length; i++) {
            groupsList.options[i].selected = (groupsList.options[i].value === group_id);
        }

        confirmButton.setAttribute('value', 'Update');
    }  else {
        document.getElementById("student_id").setAttribute('value', '0');
        document.getElementById("student_first_name").setAttribute('value', '');
        document.getElementById("student_last_name").setAttribute('value', '');
        document.getElementById("student_address").setAttribute('value', '');
        document.getElementById("student_birthday").setAttribute('value', '');
        document.getElementById("student_cities").selectedIndex = 0;
        document.getElementById("student_groups").selectedIndex = 0;
        modalTitle.textContent = 'Add Student';
        confirmButton.setAttribute('value', 'Add');
    }
});