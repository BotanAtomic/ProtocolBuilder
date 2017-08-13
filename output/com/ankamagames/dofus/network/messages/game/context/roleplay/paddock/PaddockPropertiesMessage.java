package package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockInstancesInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockPropertiesMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5824;
    private boolean _isInitialized = false;
    private PaddockInstancesInformations properties = ;
    private FuncTree _propertiestree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5824;
    }

    public PaddockPropertiesMessage initPaddockPropertiesMessage(PaddockInstancesInformations param1) {
         this.properties = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.properties = new PaddockInstancesInformations();
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
         this.serializeAs_PaddockPropertiesMessage(param1);
    }

    public void serializeAs_PaddockPropertiesMessage(ICustomDataOutput param1) {
         this.properties.serializeAs_PaddockInstancesInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockPropertiesMessage(param1);
    }

    public void deserializeAs_PaddockPropertiesMessage(ICustomDataInput param1) {
         this.properties = new PaddockInstancesInformations();
         this.properties.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockPropertiesMessage(param1);
    }

    public void deserializeAsyncAs_PaddockPropertiesMessage(FuncTree param1) {
         this._propertiestree = param1.addChild(this._propertiestreeFunc);
    }

    private void _propertiestreeFunc(ICustomDataInput param1) {
         this.properties = new PaddockInstancesInformations();
         this.properties.deserializeAsync(this._propertiestree);
    }

}