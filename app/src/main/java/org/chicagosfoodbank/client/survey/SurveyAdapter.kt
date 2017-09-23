package org.chicagosfoodbank.client.survey

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_survey.view.*
import org.chicagosfoodbank.client.R

/**
 * Created by nick.cruz on 9/23/17.
 */
class SurveyAdapter(val context: Context,
                    private var listener: SurveyAdapterListener? = null)
    : RecyclerView.Adapter<SurveyAdapter.SurveyViewHolder>() {

    interface SurveyAdapterListener {
        fun onSurveyClicked(survey: Survey)
    }

    var surveys = emptyList<Survey>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SurveyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_survey, parent, false)
        val surveyViewHolder = SurveyViewHolder(view)
        listener?.let { adapterListener ->
            surveyViewHolder.itemView.setOnClickListener {
                adapterListener.onSurveyClicked(surveyViewHolder.survey)
            }
        }
        return surveyViewHolder
    }

    override fun getItemCount(): Int = surveys.size

    override fun onBindViewHolder(holder: SurveyViewHolder?, position: Int) {
        holder?.let {
            with(surveys[position]) {
                it.survey = this
                it.titleText.text = name
            }
        }
    }

    class SurveyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var survey: Survey
        val titleText: TextView = itemView.surveyTitleText
    }
}