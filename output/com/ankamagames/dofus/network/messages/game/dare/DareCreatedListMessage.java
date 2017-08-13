package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareInformations;
import com.ankamagames.dofus.network.types.game.dare.DareVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareCreatedListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6663;
    private boolean _isInitialized = false;
    private Vector<DareInformations> daresFixedInfos;
    private Vector<DareVersatileInformations> daresVersatilesInfos;
    private FuncTree _daresFixedInfostree;
    private FuncTree _daresVersatilesInfostree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6663;
    }

    public DareCreatedListMessage initDareCreatedListMessage(Vector<DareInformations> param1,Vector<DareVersatileInformations>  param2) {
         this.daresFixedInfos = param1;
         this.daresVersatilesInfos = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.daresFixedInfos = new Vector.<DareInformations>();
         this.daresVersatilesInfos = new Vector.<DareVersatileInformations>();
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
         this.serializeAs_DareCreatedListMessage(param1);
    }

    public void serializeAs_DareCreatedListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.daresFixedInfos.length);
         int _loc2_ = 0;
         while(_loc2_ < this.daresFixedInfos.length)
         {
            (this.daresFixedInfos[_loc2_] as DareInformations).serializeAs_DareInformations(param1);
            _loc2_++;
         }
         param1.writeShort(this.daresVersatilesInfos.length);
         int _loc3_ = 0;
         while(_loc3_ < this.daresVersatilesInfos.length)
         {
            (this.daresVersatilesInfos[_loc3_] as DareVersatileInformations).serializeAs_DareVersatileInformations(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareCreatedListMessage(param1);
    }

    public void deserializeAs_DareCreatedListMessage(ICustomDataInput param1) {
         DareInformations _loc6_ = null;
         DareVersatileInformations _loc7_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new DareInformations();
            _loc6_.deserialize(param1);
            this.daresFixedInfos.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new DareVersatileInformations();
            _loc7_.deserialize(param1);
            this.daresVersatilesInfos.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareCreatedListMessage(param1);
    }

    public void deserializeAsyncAs_DareCreatedListMessage(FuncTree param1) {
         this._daresFixedInfostree = param1.addChild(this._daresFixedInfostreeFunc);
         this._daresVersatilesInfostree = param1.addChild(this._daresVersatilesInfostreeFunc);
    }

    private void _daresFixedInfostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._daresFixedInfostree.addChild(this._daresFixedInfosFunc);
            _loc3_++;
         }
    }

    private void _daresFixedInfosFunc(ICustomDataInput param1) {
         DareInformations _loc2_ = new DareInformations();
         _loc2_.deserialize(param1);
         this.daresFixedInfos.push(_loc2_);
    }

    private void _daresVersatilesInfostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._daresVersatilesInfostree.addChild(this._daresVersatilesInfosFunc);
            _loc3_++;
         }
    }

    private void _daresVersatilesInfosFunc(ICustomDataInput param1) {
         DareVersatileInformations _loc2_ = new DareVersatileInformations();
         _loc2_.deserialize(param1);
         this.daresVersatilesInfos.push(_loc2_);
    }

}