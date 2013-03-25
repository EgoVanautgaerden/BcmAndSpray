/**
 * This is a generated Shape for Spray
 */
package bcmspray3.shapes;

import java.util.List;
import java.util.ArrayList;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.algorithms.styles.*;

import org.eclipselabs.spray.runtime.graphiti.ISprayConstants;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayAbstractLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutService;
import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutType;

import org.eclipselabs.spray.runtime.graphiti.GraphitiProperties;
import org.eclipselabs.spray.runtime.graphiti.shape.DefaultSprayShape;
import org.eclipselabs.spray.runtime.graphiti.shape.SprayLayoutManager;
import org.eclipselabs.spray.runtime.graphiti.styles.ISprayStyle;

@SuppressWarnings("all")
public class ComponentShape extends DefaultSprayShape {
    
	public static enum TextIds {
		componentText,
		properties
	}
	
	public ComponentShape(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public ContainerShape getShape(ContainerShape targetContainer, ISprayStyle sprayStyle) {
		// Create a ContainerShape for this Shape
		Diagram diagram = peService.getDiagramForShape(targetContainer);
		ContainerShape containerShape = peCreateService.createContainerShape(targetContainer, true);
		SprayLayoutService.setId(containerShape, "componentShape.containerShape");
		
		// define general layout for ContainerShape
		sprayStyle.getStyle(diagram).setProportional(false);
		sprayStyle.getStyle(diagram).setStretchH(false);	   
		sprayStyle.getStyle(diagram).setStretchV(false);	   
		
		// layout data
		SprayLayoutType containerLayout = SprayLayoutType.TOP;
		SprayLayoutService.setLayoutManager(containerShape, containerLayout, 0, 0, true);
		SprayLayoutService.getLayoutData(containerShape).setVisible(true);
		
		// creates the cascaded elements (figures)
		IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setMainPictogramElement(containerShape);
		directEditingInfo.setPictogramElement(containerShape);
		
		GraphicsAlgorithm element_0 = gaService.createInvisibleRectangle(containerShape);
		element_0.setStyle(sprayStyle.getStyle(diagram));
		SprayLayoutService.setShapeFromDsl(containerShape, true);
		gaService.setLocationAndSize(element_0, 0, 0, 100, 130);
		
		ContainerShape shape_1 = peCreateService.createContainerShape(containerShape, false);
		SprayLayoutService.setId(shape_1, "componentShape.shape_1");
		RoundedRectangle element_1 = gaService.createPlainRoundedRectangle(shape_1, 20, 20);
		ISprayStyle style_1 = sprayStyle;
		element_1.setStyle(style_1.getStyle(diagram));
		gaService.setLocationAndSize(element_1, 0, 0, 100, 130);
		SprayLayoutService.setLayoutData(shape_1, 100, 130, true);
		// start RECURSIVEcREATION shape_1
		
		Shape shape_2 = peCreateService.createShape(shape_1, false);
		SprayLayoutService.setId(shape_2, "componentShape.shape_2");
		Text element_2 = gaService.createPlainText(shape_2);
		ISprayStyle style_2 = style_1;
		element_2.setStyle(style_2.getStyle(diagram));
		gaService.setLocationAndSize(element_2, 5, 5, 70, 25);
		SprayLayoutService.setLayoutData(shape_2, 70, 25, true);
		element_2.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		element_2.setVerticalAlignment(Orientation.ALIGNMENT_TOP);
		peService.setPropertyValue(element_2, ISprayConstants.TEXT_ID, TextIds.componentText.name());
		peService.setPropertyValue(shape_2, ISprayConstants.TEXT_ID, TextIds.componentText.name());
		element_2.setValue("");
		getFeatureProvider().getDirectEditingInfo().setGraphicsAlgorithm(element_2);
		// END createElement Text parent shape_1
		ContainerShape shape_3 = peCreateService.createContainerShape(shape_1, true);
		SprayLayoutService.setId(shape_3, "componentShape.shape_3");
		SprayLayoutService.setCompartment(shape_3, true);
		GraphitiProperties.set(shape_3, ISprayConstants.TEXT_ID, "properties");
		SprayLayoutType layout_3 = SprayLayoutType.VERTICAL;
		SprayLayoutService.setLayoutManager(shape_3, layout_3, 5, 5, false);
		SprayLayoutService.setLayoutData(shape_3, 100, 95);
		SprayLayoutService.getLayoutData(shape_3).setHorizontalStrechable(true);
		Rectangle element_3 = gaService.createPlainRectangle(shape_3);
		ISprayStyle style_3 = style_1;
		element_3.setStyle(style_3.getStyle(diagram));
		gaService.setLocationAndSize(element_3, 0, 35, 100, 95);
		SprayLayoutService.setLayoutData(shape_3, 100, 95, true);
		element_3.setForeground(gaService.manageColor(diagram,IColorConstant.BLACK));    	
		// start RECURSIVEcREATION shape_3
		
		// end RECURSIVEcREATION shape_3
		// end RECURSIVEcREATION shape_1
		
		
		// Set start values for height and width as properties on the element for Layout Feature
		SprayLayoutManager.setSizePictogramProperties(containerShape);
		
		// creates the anchors
		peCreateService.createChopboxAnchor(containerShape);
		
		// Fix the broken coordinate syaten for not active container shapes
        SprayAbstractLayoutManager.fixOffset(containerShape);
		return containerShape;
	}

	public SprayLayoutManager getShapeLayout() {
		SprayLayoutManager layoutManager = new SprayLayoutManager( );
		layoutManager.setMinSizeWidth(-1);	
		layoutManager.setMaxSizeWidth(-1);	
		layoutManager.setMinSizeHeight(-1);	
		layoutManager.setMaxSizeHeight(-1);	
		layoutManager.setStretchHorizontal(true);		   
		layoutManager.setStretchVertical(true);	   
		return layoutManager;
	}
	
}
