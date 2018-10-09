function selectAll() {
    $.ajax({
        url: './notes-api/notes',
        type: 'GET',
        dataType: 'json',
        success: function(list) {
            list.forEach(note => {
                $("#select-notes").append(new Option(note.name, note.id));
            });
            $("#select-notes option").get(0).setAttribute('selected', "selected");
            showSelectedNote();
            hideMessages() 
        }, 
        error: function(error) {
            showHTTPError(error);
        }
      });
}

function showSelectedNote() {
    var id = $("#select-notes").val();
    if(id) {
        $.ajax({
            url: './notes-api/notes/' + id,
            type: 'GET',
            dataType: 'json',
            success: function(note) {
                $("#txt-note-content").val(note.content);
                $("#txt-note-name").val(note.name);
                hideMessages() 
            }, 
            error: function(error) {
                showHTTPError(error);
            }
          });
    }
    
}

function saveCurrentNote() {
    var name = $("#txt-note-name").val();
    var content = $("#txt-note-content").val();
    var id = $("#select-notes").val();

    if(!name || name.length == 0) {
        showErrorMessage("Le nom est obligatoire");
    } else if(!content || content.length == 0) {
        showErrorMessage("Le contenu est obligatoire");

    } else {
        var note = new Object();
        note.name = name;
        note.content = content;
        note.id = id;

        $.ajax({
            url: './notes-api/notes',
            type: 'POST',
            dataType: 'json',
            contentType:"application/json; charset=utf-8",
            data: JSON.stringify(note),
            success: function(note) {
                if(!id) {
                    $("#select-notes").append(new Option(note.name, note.id));
                } else {
                    $("#select-notes option[value="+ id +"]").html(note.name);
                }
                showSuccessMessage("Note enregistrée avec succes");
            }, 
            error: function(error) {
                showHTTPError(error);
            }
        });
    }
}

function deleteCurrentNote() {
    var id = $("#select-notes").val();
    if(id) {
        $.ajax({
            url: './notes-api/notes/' + id,
            type: 'DELETE',
            dataType: 'json',
            success: function() {
                $("#select-notes option[value="+ id +"]").remove();
                $("#txt-note-name").val(null);
                $("#txt-note-content").val(null);
                showSuccessMessage("Note supprimée avec succes");                
            }, 
            error: function(error) {
                showHTTPError(error);
            }
          });
    }
}

function createNote() {
    $("#txt-note-name").val(null);
    $("#txt-note-content").val(null);
    $("#select-notes").val(null);
}

function showHTTPError(error) {

    if(error.responseText) {
        showErrorMessage(JSON.parse(error.responseText).message) 
    } else if(error.statusText) {
        showErrorMessage(error.statusText); 
    } else {
        showErrorMessage("Erreur");
    }
}

function showErrorMessage(message) {
    hideMessages() 
    $("#alert-message").html(message);
    $("#alert-message").css('visibility', 'visible');
}

function showSuccessMessage(message) {
    hideMessages() 
    $("#info-message").html(message);
    $("#info-message").css('visibility', 'visible');
}

function hideMessages() {
    $("#info-message").css('visibility', 'hidden');
    $("#alert-message").css('visibility', 'hidden');
}

$( document ).ready(function() {
    selectAll();
});
