package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;
import java.lang.Exception;

public class DareSubscribedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6660;
    private boolean _isInitialized = false;
    private Number dareId = 0;
    private boolean success = false;
    private boolean subscribe = false;
    private DareVersatileInformations dareVersatilesInfos;
    private FuncTree _dareVersatilesInfostree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6660;
    }

    public DareSubscribedMessage initDareSubscribedMessage(Number param1,boolean  param2,boolean  param3,DareVersatileInformations  param4) {
         this.dareId = param1;
         this.success = param2;
         this.subscribe = param3;
         this.dareVersatilesInfos = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dareId = 0;
         this.success = false;
         this.subscribe = false;
         this.dareVersatilesInfos = new DareVersatileInformations();
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
         this.serializeAs_DareSubscribedMessage(param1);
    }

    public void serializeAs_DareSubscribedMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.success);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.subscribe);
         param1.writeByte(_loc2_);
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
         }
         param1.writeDouble(this.dareId);
         this.dareVersatilesInfos.serializeAs_DareVersatileInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareSubscribedMessage(param1);
    }

    public void deserializeAs_DareSubscribedMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._dareIdFunc(param1);
         this.dareVersatilesInfos = new DareVersatileInformations();
         this.dareVersatilesInfos.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareSubscribedMessage(param1);
    }

    public void deserializeAsyncAs_DareSubscribedMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._dareIdFunc);
         this._dareVersatilesInfostree = param1.addChild(this._dareVersatilesInfostreeFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.success = BooleanByteWrapper.getFlag(_loc2_,0);
         this.subscribe = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _dareIdFunc(ICustomDataInput param1) {
         this.dareId = param1.readDouble();
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element of DareSubscribedMessage.dareId.");
         }
    }

    private void _dareVersatilesInfostreeFunc(ICustomDataInput param1) {
         this.dareVersatilesInfos = new DareVersatileInformations();
         this.dareVersatilesInfos.deserializeAsync(this._dareVersatilesInfostree);
    }

}