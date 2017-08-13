package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class MimicryObjectFeedAndAssociateRequestMessage extends SymbioticObjectAssociateRequestMessage implements INetworkMessage {

    private int protocolId = 6460;
    private boolean _isInitialized = false;
    private int foodUID = 0;
    private int foodPos = 0;
    private boolean preview = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6460;
    }

    public MimicryObjectFeedAndAssociateRequestMessage initMimicryObjectFeedAndAssociateRequestMessage(int param1,int  param2,int  param3,int  param4,int  param5,int  param6,boolean  param7) {
         super.initSymbioticObjectAssociateRequestMessage(param1,param2,param3,param4);
         this.foodUID = param5;
         this.foodPos = param6;
         this.preview = param7;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.foodUID = 0;
         this.foodPos = 0;
         this.preview = false;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MimicryObjectFeedAndAssociateRequestMessage(param1);
    }

    public void serializeAs_MimicryObjectFeedAndAssociateRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_SymbioticObjectAssociateRequestMessage(param1);
         if(this.foodUID < 0)
            throw new Exception("Forbidden value (" + this.foodUID + ") on element foodUID.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MimicryObjectFeedAndAssociateRequestMessage(param1);
    }

    public void deserializeAs_MimicryObjectFeedAndAssociateRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._foodUIDFunc(param1);
         this._foodPosFunc(param1);
         this._previewFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MimicryObjectFeedAndAssociateRequestMessage(param1);
    }

    public void deserializeAsyncAs_MimicryObjectFeedAndAssociateRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._foodUIDFunc);
         param1.addChild(this._foodPosFunc);
         param1.addChild(this._previewFunc);
    }

    private void _foodUIDFunc(ICustomDataInput param1) {
         this.foodUID = param1.readVarUhInt();
         if(this.foodUID < 0)
            throw new Exception("Forbidden value (" + this.foodUID + ") on element of MimicryObjectFeedAndAssociateRequestMessage.foodUID.");
    }

    private void _foodPosFunc(ICustomDataInput param1) {
         this.foodPos = param1.readUnsignedByte();
         if(this.foodPos < 0 || this.foodPos > 255)
            throw new Exception("Forbidden value (" + this.foodPos + ") on element of MimicryObjectFeedAndAssociateRequestMessage.foodPos.");
    }

    private void _previewFunc(ICustomDataInput param1) {
         this.preview = param1.readBoolean();
    }

}