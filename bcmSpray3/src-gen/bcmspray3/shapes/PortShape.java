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
public class PortShape extends DefaultSprayShape {

    public static enum TextIds {
        portText
    }

    public PortShape(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public ContainerShape getShape(ContainerShape targetContainer, ISprayStyle sprayStyle) {
        // Create a ContainerShape for this Shape
        Diagram diagram = peService.getDiagramForShape(targetContainer);
        ContainerShape containerShape = peCreateService.createContainerShape(targetContainer, true);
        SprayLayoutService.setId(containerShape, "portShape.containerShape");

        // define general layout for ContainerShape
        sprayStyle.getStyle(diagram).setProportional(false);
        sprayStyle.getStyle(diagram).setStretchH(false);
        sprayStyle.getStyle(diagram).setStretchV(false);

        // layout data
        SprayLayoutType containerLayout = SprayLayoutType.FIT;
        SprayLayoutService.setLayoutManager(containerShape, containerLayout, 0, 0, true);
        SprayLayoutService.getLayoutData(containerShape).setVisible(true);

        // creates the cascaded elements (figures)
        IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
        directEditingInfo.setMainPictogramElement(containerShape);
        directEditingInfo.setPictogramElement(containerShape);

        GraphicsAlgorithm element_0 = gaService.createInvisibleRectangle(containerShape);
        element_0.setStyle(sprayStyle.getStyle(diagram));
        SprayLayoutService.setShapeFromDsl(containerShape, true);
        gaService.setLocationAndSize(element_0, 0, 0, 30, 30);

        ContainerShape shape_1 = peCreateService.createContainerShape(containerShape, false);
        SprayLayoutService.setId(shape_1, "portShape.shape_1");
        SprayLayoutService.setCompartment(shape_1, false);
        Rectangle element_1 = gaService.createPlainRectangle(shape_1);
        ISprayStyle style_1 = sprayStyle;
        element_1.setStyle(style_1.getStyle(diagram));
        gaService.setLocationAndSize(element_1, 0, 0, 30, 30);
        SprayLayoutService.setLayoutData(shape_1, 30, 30, true);
        // start RECURSIVEcREATION shape_1

        Shape shape_2 = peCreateService.createShape(shape_1, false);
        SprayLayoutService.setId(shape_2, "portShape.shape_2");
        Text element_2 = gaService.createPlainText(shape_2);
        ISprayStyle style_2 = style_1;
        element_2.setStyle(style_2.getStyle(diagram));
        gaService.setLocationAndSize(element_2, 5, 1, 15, 15);
        SprayLayoutService.setLayoutData(shape_2, 15, 15, true);
        element_2.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
        element_2.setVerticalAlignment(Orientation.ALIGNMENT_TOP);
        peService.setPropertyValue(element_2, ISprayConstants.TEXT_ID, TextIds.portText.name());
        peService.setPropertyValue(shape_2, ISprayConstants.TEXT_ID, TextIds.portText.name());
        element_2.setValue("");
        getFeatureProvider().getDirectEditingInfo().setGraphicsAlgorithm(element_2);
        // END createElement Text parent shape_1
        // end RECURSIVEcREATION shape_1

        // Set start values for height and width as properties on the element for Layout Feature
        SprayLayoutManager.setSizePictogramProperties(containerShape);

        // creates the anchors
        {
            FixPointAnchor fixAnchor = peCreateService.createFixPointAnchor(containerShape);
            Point fixAnchorPoint = gaService.createPoint(0, 15);
            fixAnchor.setLocation(fixAnchorPoint);
            Ellipse ellipse = gaService.createEllipse(fixAnchor);
            ellipse.setFilled(true);
            ellipse.setLineVisible(false);
            ellipse.setBackground(gaService.manageColor(diagram, IColorConstant.GRAY));
            ellipse.setX(0);
            ellipse.setY(-3);
            ellipse.setWidth(6);
            ellipse.setHeight(6);
        }
        {
            FixPointAnchor fixAnchor = peCreateService.createFixPointAnchor(containerShape);
            Point fixAnchorPoint = gaService.createPoint(30, 15);
            fixAnchor.setLocation(fixAnchorPoint);
            Ellipse ellipse = gaService.createEllipse(fixAnchor);
            ellipse.setFilled(true);
            ellipse.setLineVisible(false);
            ellipse.setBackground(gaService.manageColor(diagram, IColorConstant.GRAY));
            ellipse.setX(-6);
            ellipse.setY(-3);
            ellipse.setWidth(6);
            ellipse.setHeight(6);
        }

        // Fix the broken coordinate syaten for not active container shapes
        SprayAbstractLayoutManager.fixOffset(containerShape);
        return containerShape;
    }

    public SprayLayoutManager getShapeLayout() {
        SprayLayoutManager layoutManager = new SprayLayoutManager();
        layoutManager.setMinSizeWidth(-1);
        layoutManager.setMaxSizeWidth(-1);
        layoutManager.setMinSizeHeight(-1);
        layoutManager.setMaxSizeHeight(-1);
        layoutManager.setStretchHorizontal(true);
        layoutManager.setStretchVertical(true);
        return layoutManager;
    }

}
