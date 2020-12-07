package ise308.karabel.cengizhan.notetocengizhankarabel

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class DialogNewNote: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity!!)

        val inflater = activity!!.layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_new_note, null)

        val editTitle = dialogLayout.findViewById<EditText>(R.id.edit_title)
        val editDescription = dialogLayout.findViewById<EditText>(R.id.edit_description)
        val checkBoxIdea = dialogLayout.findViewById<CheckBox>(R.id.checkBox_idea)
        val checkBoxToDo = dialogLayout.findViewById<CheckBox>(R.id.checkBox_todo)
        val checkBoxImportant = dialogLayout.findViewById<CheckBox>(R.id.checkBox_important)
        val buttonOk = dialogLayout.findViewById<Button>(R.id.button_ok)
        val buttonCancel = dialogLayout.findViewById<Button>(R.id.button_cancel)




        builder.setView(dialogLayout)
            .setMessage(resources.getString(R.string.add_new_note))


        buttonCancel.setOnClickListener{
            dismiss()
        }

        buttonOk.setOnClickListener{
            val newNote = Note()
            newNote.title = editTitle.text.toString()
            newNote.description = editDescription.text.toString()
            newNote.idea = checkBoxIdea.isChecked
            newNote.todo = checkBoxToDo.isChecked
            newNote.important = checkBoxImportant.isChecked

            val callingActivity = activity as MainActivity?
            callingActivity!!.createNewNote(newNote)

            dismiss()
        }
        return builder.create()
    }
}