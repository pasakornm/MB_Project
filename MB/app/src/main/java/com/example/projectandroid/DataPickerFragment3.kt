package com.example.projectandroid

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
class DatePickerFragment3 : DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(saveInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity!!, 2, this, year, month, day)
    }
    override fun onDateSet(view: DatePicker, year: Int, month: Int,day: Int) {
        var tv: TextView? = activity?.findViewById(R.id.datafragment3)
        tv!!.text = formatDate(year, month, day)
    }
    override fun onCancel(dialog: DialogInterface) {
        Toast.makeText(activity, "Please select a date.", Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }
    private fun formatDate(year: Int, month: Int, day: Int): String {
        var calendar: Calendar = Calendar.getInstance();
        calendar.set(year, month, day)
        val chosenDate = calendar.time
        val df = SimpleDateFormat("dd/MM/YYYY")
        return df.format(chosenDate)
    }
}