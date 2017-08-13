package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectFeedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6290;
    private boolean _isInitialized = false;
    private int objectUID = 0;
    private int foodUID = 0;
    private int foodQuantity = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6290;
    }

    public ObjectFeedMessage initObjectFeedMessage(int param1,int  param2,int  param3) {
         this.objectUID = param1;
         this.foodUID = param2;
         this.foodQuantity = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectUID = 0;
         this.foodUID = 0;
         this.foodQuantity = 0;
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
         this.serializeAs_ObjectFeedMessage(param1);
    }

    public void serializeAs_ObjectFeedMessage(ICustomDataOutput param1) {
         if(this.objectUID < 0)
            throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectFeedMessage(param1);
    }

    public void deserializeAs_ObjectFeedMessage(ICustomDataInput param1) {
         this._objectUIDFunc(param1);
         this._foodUIDFunc(param1);
         this._foodQuantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectFeedMessage(param1);
    }

    public void deserializeAsyncAs_ObjectFeedMessage(FuncTree param1) {
         param1.addChild(this._objectUIDFunc);
         param1.addChild(this._foodUIDFunc);
         param1.addChild(this._foodQuantityFunc);
    }

    private void _objectUIDFunc(ICustomDataInput param1) {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of ObjectFeedMessage.objectUID.");
    }

    private void _foodUIDFunc(ICustomDataInput param1) {
         this.foodUID = param1.readVarUhInt();
         if(this.foodUID < 0)
            throw new Exception("Forbidden value (" + this.foodUID + ") on element of ObjectFeedMessage.foodUID.");
    }

    private void _foodQuantityFunc(ICustomDataInput param1) {
         this.foodQuantity = param1.readVarUhInt();
         if(this.foodQuantity < 0)
            throw new Exception("Forbidden value (" + this.foodQuantity + ") on element of ObjectFeedMessage.foodQuantity.");
    }

}