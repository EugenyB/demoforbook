
let myAddSubjectDialog = document.getElementById("add_subject");
myAddSubjectDialog.addEventListener('show.bs.modal', function (event) {

    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    let form = document.getElementById("add_subject_form");
    form.setAttribute('action', link);
    let title = button.getAttribute('data-bs-title');
    let duration = button.getAttribute('data-bs-duration');
    let semester = button.getAttribute('data-bs-semester');
    let description = button.getAttribute('data-bs-description');
    let approveButton = document.getElementById("approve_subject");
    let titleEdit = document.getElementById("subject_title");
    let durationEdit = document.getElementById("subject_duration");
    let semesterEdit = document.getElementById("subject_semester");
    let descriptionEdit = document.getElementById("subject_description");
    let idField = document.getElementById("subject_id");

    let dialogTitle = myAddSubjectDialog.querySelector('.modal-title');
    if (button.getAttribute('data-bs-ident') === '#add') {
        idField.value = '0';
        titleEdit.value = '';
        durationEdit.value = '';
        semesterEdit.value = '';
        descriptionEdit.value = '';

        approveButton.textContent = "Add Subject";
        dialogTitle.textContent = "Add Subject";
    } else {
        idField.value = button.getAttribute('data-bs-id');
        titleEdit.value = title;
        durationEdit.value = duration;
        semesterEdit.value = semester;
        descriptionEdit.value = description;

        dialogTitle.textContent = "Edit Subject";
        approveButton.textContent = "Update Subject";
    }
});