package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareCreatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6668;
    private boolean _isInitialized = false;
    private DareInformations dareInfos;
    private boolean needNotifications = false;
    private FuncTree _dareInfostree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6668;
    }

    public DareCreatedMessage initDareCreatedMessage(DareInformations param1,boolean  param2) {
         this.dareInfos = param1;
         this.needNotifications = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dareInfos = new DareInformations();
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
         this.serializeAs_DareCreatedMessage(param1);
    }

    public void serializeAs_DareCreatedMessage(ICustomDataOutput param1) {
         this.dareInfos.serializeAs_DareInformations(param1);
         param1.writeBoolean(this.needNotifications);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareCreatedMessage(param1);
    }

    public void deserializeAs_DareCreatedMessage(ICustomDataInput param1) {
         this.dareInfos = new DareInformations();
         this.dareInfos.deserialize(param1);
         this._needNotificationsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareCreatedMessage(param1);
    }

    public void deserializeAsyncAs_DareCreatedMessage(FuncTree param1) {
         this._dareInfostree = param1.addChild(this._dareInfostreeFunc);
         param1.addChild(this._needNotificationsFunc);
    }

    private void _dareInfostreeFunc(ICustomDataInput param1) {
         this.dareInfos = new DareInformations();
         this.dareInfos.deserializeAsync(this._dareInfostree);
    }

    private void _needNotificationsFunc(ICustomDataInput param1) {
         this.needNotifications = param1.readBoolean();
    }

}