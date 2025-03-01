package com.example.util.simpletimetracker.navigation

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import com.example.util.simpletimetracker.R
import com.example.util.simpletimetracker.feature_dialogs.archive.view.ArchiveDialogFragment
import com.example.util.simpletimetracker.feature_change_category.view.ChangeCategoryFragment
import com.example.util.simpletimetracker.feature_change_record.view.ChangeRecordFragment
import com.example.util.simpletimetracker.feature_change_record_tag.view.ChangeRecordTagFragment
import com.example.util.simpletimetracker.feature_change_record_type.view.ChangeRecordTypeFragment
import com.example.util.simpletimetracker.feature_change_running_record.view.ChangeRunningRecordFragment
import com.example.util.simpletimetracker.feature_dialogs.cardOrder.view.CardOrderDialogFragment
import com.example.util.simpletimetracker.feature_dialogs.dateTime.DateTimeDialogFragment
import com.example.util.simpletimetracker.feature_dialogs.duration.view.DurationDialogFragment
import com.example.util.simpletimetracker.feature_dialogs.emojiSelection.view.EmojiSelectionDialogFragment
import com.example.util.simpletimetracker.feature_dialogs.recordTagSelection.RecordTagSelectionDialogFragment
import com.example.util.simpletimetracker.feature_dialogs.standard.StandardDialogFragment
import com.example.util.simpletimetracker.feature_dialogs.typesFilter.view.TypesFilterDialogFragment
import com.example.util.simpletimetracker.feature_records_all.view.RecordsAllFragment
import com.example.util.simpletimetracker.feature_statistics_detail.view.StatisticsDetailFragment
import javax.inject.Inject

class ScreenResolverImpl @Inject constructor() : ScreenResolver {

    override fun navigate(
        navController: NavController?,
        screen: Screen,
        data: Any?,
        sharedElements: Map<Any, String>?
    ) {
        val navExtras = toNavExtras(sharedElements)

        when (screen) {
            // Screens
            Screen.CHANGE_RECORD_TYPE ->
                navController?.navigate(
                    R.id.action_mainFragment_to_changeRecordTypeFragment,
                    ChangeRecordTypeFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.CHANGE_RECORD_RUNNING ->
                navController?.navigate(
                    R.id.action_mainFragment_to_changeRunningRecordFragment,
                    ChangeRunningRecordFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.CHANGE_RECORD_FROM_MAIN ->
                navController?.navigate(
                    R.id.action_mainFragment_to_changeRecordFragment,
                    ChangeRecordFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.CHANGE_RECORD_FROM_RECORDS_ALL ->
                navController?.navigate(
                    R.id.action_recordsAllFragment_to_changeRecordFragment,
                    ChangeRecordFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.STATISTICS_DETAIL ->
                navController?.navigate(
                    R.id.action_mainFragment_to_statisticsDetailFragment,
                    StatisticsDetailFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.RECORDS_ALL ->
                navController?.navigate(
                    R.id.action_statisticsDetailFragment_to_recordsAllFragment,
                    RecordsAllFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.CATEGORIES ->
                navController?.navigate(
                    R.id.action_mainFragment_to_categoriesFragment,
                    null,
                    null,
                    navExtras
                )
            Screen.ARCHIVE ->
                navController?.navigate(
                    R.id.action_mainFragment_to_archiveFragment,
                    null,
                    null,
                    navExtras
                )
            Screen.CHANGE_CATEGORY ->
                navController?.navigate(
                    R.id.action_categoriesFragment_to_changeCategoryFragment,
                    ChangeCategoryFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.CHANGE_RECORD_TAG ->
                navController?.navigate(
                    R.id.action_categoriesFragment_to_changeRecordTagFragment,
                    ChangeRecordTagFragment.createBundle(data),
                    null,
                    navExtras
                )

            // Dialogs
            Screen.STANDARD_DIALOG ->
                navController?.navigate(
                    R.id.standardDialogFragment,
                    StandardDialogFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.DATE_TIME_DIALOG ->
                navController?.navigate(
                    R.id.dateTimeDialog,
                    DateTimeDialogFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.DURATION_DIALOG ->
                navController?.navigate(
                    R.id.durationDialog,
                    DurationDialogFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.CHART_FILTER_DIALOG ->
                navController?.navigate(
                    R.id.chartFilerDialogFragment,
                    null,
                    null,
                    navExtras
                )
            Screen.TYPES_FILTER_DIALOG ->
                navController?.navigate(
                    R.id.typesFilterDialogFragment,
                    TypesFilterDialogFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.CARD_SIZE_DIALOG ->
                navController?.navigate(
                    R.id.cardSizeDialogFragment,
                    null,
                    null,
                    navExtras
                )
            Screen.CARD_ORDER_DIALOG ->
                navController?.navigate(
                    R.id.cardOrderDialogFragment,
                    CardOrderDialogFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.EMOJI_SELECTION_DIALOG ->
                navController?.navigate(
                    R.id.emojiSelectionDialogFragment,
                    EmojiSelectionDialogFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.ARCHIVE_DIALOG ->
                navController?.navigate(
                    R.id.archiveDialogFragment,
                    ArchiveDialogFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.RECORD_TAG_SELECTION_DIALOG ->
                navController?.navigate(
                    R.id.recordTagSelectionDialogFragment,
                    RecordTagSelectionDialogFragment.createBundle(data),
                    null,
                    navExtras
                )
            Screen.CSV_EXPORT_SETTINGS_DIALOG ->
                navController?.navigate(
                    R.id.csvExportSettingsDialogFragment,
                    null,
                    null,
                    navExtras
                )
            else -> {
                // Do nothing
            }
        }
    }

    private fun toNavExtras(sharedElements: Map<Any, String>?): Navigator.Extras {
        return FragmentNavigator.Extras.Builder().apply {
            sharedElements?.forEach { (key, value) ->
                (key as? View)?.let { view ->
                    addSharedElement(view, value)
                }
            }
        }.build()
    }
}