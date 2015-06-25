function plotAdverse(chartId, data){
	var maxYVal= getMaxDataPoint(data);
	var adversePlot;
	var colorsArray = ['#00B25C', '#1C0118', '#FF9B40', '#A40004', '#06799F' , '#666666'];
	 console.log(data);
		adversePlot=$.jqplot(chartId,[data], {
	        // Provide a custom seriesColors array to override the default colors.
	        seriesColors:colorsArray,
	        seriesDefaults:{
	            renderer:$.jqplot.BarRenderer,
	            rendererOptions: {
	                // Set the varyBarColor option to true to use different colors for each bar.
	                // The default series colors are used.
	                varyBarColor: true,
	                barMargin:0,
	                //barWidth:20
	            }
	        },
	        title:{
	            show:false
	        },    
	        axes:{
	            xaxis:{
	                renderer: $.jqplot.CategoryAxisRenderer,
	                drawMajorGridlines: false,
	                showTicks:false
	            },
	            yaxis:{
	                drawMajorGridlines: false,
	                numberTicks:1,
	                tickInterval: maxYVal,
	                min: 0,
	               
	            }
	        },
	        grid: {
	            background: 'transparent',
	            drawBorder:false
	        }
	    });
	    $('#' + chartId).bind('jqplotDataHighlight', function(evt, seriesIndex, pointIndex, data){
            var selEvent = adversePlot.data[seriesIndex][pointIndex][0];
	        $('.eventTypeDiv').each(function(index){
	            if($(this).attr('eventtype')!= selEvent){
	                 $(this).switchClass("highlighted","unHighlighted");
	            }else{
	               if($(this).hasClass('unHighlighted')){
	                    $(this).switchClass("unHighlighted", "highlighted");
	                } 
	            }
	        });
	    });
	    $('#' + chartId).bind('jqplotDataUnhighlight', function(evt, seriesIndex, pointIndex, data){
	        $('.highlighted').switchClass("highlighted","unHighlighted");        
	    });
	    
	    $('#' + chartId).bind('jqplotDataClick', function(evt, seriesIndex, pointIndex, data){
var selEvent = adversePlot.data[seriesIndex][pointIndex][0];
	        $('.eventTypeDiv').each(function(index){
	            if($(this).attr('eventtype')!= selEvent){
	                 $(this).switchClass("highlighted","unHighlighted");
	            }else{
	               if($(this).hasClass('unHighlighted')){
	                    $(this).switchClass("unHighlighted", "highlighted");
	                } 
	            }
	        });
	        if($('#'+data[pointIndex][0]+'Data').hasClass('unHighlighted')){
	            $('#'+data[pointIndex][0]+'Data').switchClass("unHighlighted", "highlighted");
	        }
	    });    

	adversePlot.replot();
}

    


function getMaxDataPoint(data){
    var maxValue=0;
    for(i=0; i<data.length; i++){
        if(data[i][1]>maxValue){
            maxValue=data[i][1];
        }
    }
    return maxValue;
}
