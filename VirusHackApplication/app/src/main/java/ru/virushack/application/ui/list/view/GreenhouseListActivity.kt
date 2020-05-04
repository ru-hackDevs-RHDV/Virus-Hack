package ru.virushack.application.ui.list.view

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_green_house_list.*
import ru.virushack.application.R
import ru.virushack.application.models.GreenhouseModel
import ru.virushack.application.ui.base.view.BaseActivity
import ru.virushack.application.ui.details.view.GreenhouseDetailsActivity
import ru.virushack.application.ui.list.interactor.GreenhouseListMvpInteractor
import ru.virushack.application.ui.list.presenter.GreenhouseListMvpPresenter
import javax.inject.Inject

class GreenhouseListActivity : BaseActivity(R.layout.activity_green_house_list), GreenhouseListView {

    companion object {
        const val ARG_MODEL = "ARG_MODEL"
    }

    @Inject
    lateinit var presenter: GreenhouseListMvpPresenter<GreenhouseListView, GreenhouseListMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun showGreenHouses(data: List<GreenhouseModel>) {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@GreenhouseListActivity)
            adapter = GreenhouseListRvAdapter(data) { model ->
                startActivity(Intent(this@GreenhouseListActivity, GreenhouseDetailsActivity::class.java).apply {
                    putExtra(ARG_MODEL, model)
                })
            }
        }
    }

}