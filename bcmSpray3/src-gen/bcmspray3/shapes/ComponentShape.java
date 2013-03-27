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
		comps,
		properties,
		properties2
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
		gaService.setLocationAndSize(element_0, 0, 0, 140, 130);
		
		ContainerShape shape_1 = peCreateService.createContainerShape(containerShape, false);
		SprayLayoutService.setId(shape_1, "componentShape.shape_1");
		SprayLayoutService.setCompartment(shape_1, false);
		Rectangle element_1 = gaService.createPlainRectangle(shape_1);
		ISprayStyle style_1 = sprayStyle;
		element_1.setStyle(style_1.getStyle(diagram));
		gaService.setLocationAndSize(element_1, 0, 0, 140, 130);
		SprayLayoutService.setLayoutData(shape_1, 140, 130, true);
		element_1.setTransparency(0.9);		
		// start RECURSIVEcREATION shape_1
		
		ContainerShape shape_2 = peCreateService.createContainerShape(shape_1, false);
		SprayLayoutService.setId(shape_2, "componentShape.shape_2");
		RoundedRectangle element_2 = gaService.createPlainRoundedRectangle(shape_2, 20, 20);
		ISprayStyle style_2 = style_1;
		element_2.setStyle(style_2.getStyle(diagram));
		gaService.setLocationAndSize(element_2, 20, 0, 100, 130);
		SprayLayoutService.setLayoutData(shape_2, 100, 130, true);
		// start RECURSIVEcREATION shape_2
		
		Shape shape_3 = peCreateService.createShape(shape_2, false);
		SprayLayoutService.setId(shape_3, "componentShape.shape_3");
		Text element_3 = gaService.createPlainText(shape_3);
		ISprayStyle style_3 = style_2;
		element_3.setStyle(style_3.getStyle(diagram));
		gaService.setLocationAndSize(element_3, 5, 5, 80, 25);
		SprayLayoutService.setLayoutData(shape_3, 80, 25, true);
		element_3.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		element_3.setVerticalAlignment(Orientation.ALIGNMENT_MIDDLE);
		peService.setPropertyValue(element_3, ISprayConstants.TEXT_ID, TextIds.componentText.name());
		peService.setPropertyValue(shape_3, ISprayConstants.TEXT_ID, TextIds.componentText.name());
		element_3.setValue("");
		getFeatureProvider().getDirectEditingInfo().setGraphicsAlgorithm(element_3);
		// END createElement Text parent shape_2
		ContainerShape shape_4 = peCreateService.createContainerShape(shape_2, true);
		SprayLayoutService.setId(shape_4, "componentShape.shape_4");
		SprayLayoutService.setCompartment(shape_4, true);
		GraphitiProperties.set(shape_4, ISprayConstants.TEXT_ID, "comps");
		SprayLayoutType layout_4 = SprayLayoutType.FIXED;
		SprayLayoutService.setLayoutManager(shape_4, layout_4, 5, 5, false);
		SprayLayoutService.setLayoutData(shape_4, 100, 95);
		SprayLayoutService.getLayoutData(shape_4).setHorizontalStrechable(true);
		Rectangle element_4 = gaService.createPlainRectangle(shape_4);
		ISprayStyle style_4 = style_2;
		element_4.setStyle(style_4.getStyle(diagram));
		gaService.setLocationAndSize(element_4, 0, 35, 100, 95);
		SprayLayoutService.setLayoutData(shape_4, 100, 95, true);
		element_4.setForeground(gaService.manageColor(diagram,IColorConstant.BLACK));    	
		// start RECURSIVEcREATION shape_4
		
		// end RECURSIVEcREATION shape_4
		// end RECURSIVEcREATION shape_2
		ContainerShape shape_5 = peCreateService.createContainerShape(shape_1, true);
		SprayLayoutService.setId(shape_5, "componentShape.shape_5");
		SprayLayoutService.setCompartment(shape_5, true);
		GraphitiProperties.set(shape_5, ISprayConstants.TEXT_ID, "properties");
		SprayLayoutType layout_5 = SprayLayoutType.FIXED;
		SprayLayoutService.setLayoutManager(shape_5, layout_5, 3, 5, false);
		SprayLayoutService.setLayoutData(shape_5, 40, 90);
		SprayLayoutService.getLayoutData(shape_5).setHorizontalStrechable(false);
		Rectangle element_5 = gaService.createPlainRectangle(shape_5);
		ISprayStyle style_5 = style_1;
		element_5.setStyle(style_5.getStyle(diagram));
		gaService.setLocationAndSize(element_5, 100, 40, 40, 90);
		SprayLayoutService.setLayoutData(shape_5, 40, 90, true);
		element_5.setTransparency(0.9);		
		// start RECURSIVEcREATION shape_5
		
		// end RECURSIVEcREATION shape_5
		ContainerShape shape_6 = peCreateService.createContainerShape(shape_1, true);
		SprayLayoutService.setId(shape_6, "componentShape.shape_6");
		SprayLayoutService.setCompartment(shape_6, true);
		GraphitiProperties.set(shape_6, ISprayConstants.TEXT_ID, "properties2");
		SprayLayoutType layout_6 = SprayLayoutType.FIXED;
		SprayLayoutService.setLayoutManager(shape_6, layout_6, 3, 5, false);
		SprayLayoutService.setLayoutData(shape_6, 40, 90);
		SprayLayoutService.getLayoutData(shape_6).setHorizontalStrechable(false);
		Rectangle element_6 = gaService.createPlainRectangle(shape_6);
		ISprayStyle style_6 = style_1;
		element_6.setStyle(style_6.getStyle(diagram));
		gaService.setLocationAndSize(element_6, 0, 40, 40, 90);
		SprayLayoutService.setLayoutData(shape_6, 40, 90, true);
		element_6.setTransparency(0.9);		
		// start RECURSIVEcREATION shape_6
		
		// end RECURSIVEcREATION shape_6
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
