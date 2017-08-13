package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareInformations;
import com.ankamagames.dofus.network.types.game.dare.DareVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareInformationsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6656;
    private boolean _isInitialized = false;
    private DareInformations dareFixedInfos;
    private DareVersatileInformations dareVersatilesInfos;
    private FuncTree _dareFixedInfostree;
    private FuncTree _dareVersatilesInfostree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6656;
    }

    public DareInformationsMessage initDareInformationsMessage(DareInformations param1,DareVersatileInformations  param2) {
         this.dareFixedInfos = param1;
         this.dareVersatilesInfos = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dareFixedInfos = new DareInformations();
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
         this.serializeAs_DareInformationsMessage(param1);
    }

    public void serializeAs_DareInformationsMessage(ICustomDataOutput param1) {
         this.dareFixedInfos.serializeAs_DareInformations(param1);
         this.dareVersatilesInfos.serializeAs_DareVersatileInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareInformationsMessage(param1);
    }

    public void deserializeAs_DareInformationsMessage(ICustomDataInput param1) {
         this.dareFixedInfos = new DareInformations();
         this.dareFixedInfos.deserialize(param1);
         this.dareVersatilesInfos = new DareVersatileInformations();
         this.dareVersatilesInfos.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareInformationsMessage(param1);
    }

    public void deserializeAsyncAs_DareInformationsMessage(FuncTree param1) {
         this._dareFixedInfostree = param1.addChild(this._dareFixedInfostreeFunc);
         this._dareVersatilesInfostree = param1.addChild(this._dareVersatilesInfostreeFunc);
    }

    private void _dareFixedInfostreeFunc(ICustomDataInput param1) {
         this.dareFixedInfos = new DareInformations();
         this.dareFixedInfos.deserializeAsync(this._dareFixedInfostree);
    }

    private void _dareVersatilesInfostreeFunc(ICustomDataInput param1) {
         this.dareVersatilesInfos = new DareVersatileInformations();
         this.dareVersatilesInfos.deserializeAsync(this._dareVersatilesInfostree);
    }

}