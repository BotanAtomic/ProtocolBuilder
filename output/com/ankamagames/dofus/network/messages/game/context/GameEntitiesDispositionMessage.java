package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.IdentifiedEntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameEntitiesDispositionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5696;
    private boolean _isInitialized = false;
    private Vector<IdentifiedEntityDispositionInformations> dispositions;
    private FuncTree _dispositionstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5696;
    }

    public GameEntitiesDispositionMessage initGameEntitiesDispositionMessage(Vector<IdentifiedEntityDispositionInformations> param1) {
         this.dispositions = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dispositions = new Vector.<IdentifiedEntityDispositionInformations>();
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
         this.serializeAs_GameEntitiesDispositionMessage(param1);
    }

    public void serializeAs_GameEntitiesDispositionMessage(ICustomDataOutput param1) {
         param1.writeShort(this.dispositions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.dispositions.length)
         {
            (this.dispositions[_loc2_] as IdentifiedEntityDispositionInformations).serializeAs_IdentifiedEntityDispositionInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameEntitiesDispositionMessage(param1);
    }

    public void deserializeAs_GameEntitiesDispositionMessage(ICustomDataInput param1) {
         IdentifiedEntityDispositionInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new IdentifiedEntityDispositionInformations();
            _loc4_.deserialize(param1);
            this.dispositions.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameEntitiesDispositionMessage(param1);
    }

    public void deserializeAsyncAs_GameEntitiesDispositionMessage(FuncTree param1) {
         this._dispositionstree = param1.addChild(this._dispositionstreeFunc);
    }

    private void _dispositionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._dispositionstree.addChild(this._dispositionsFunc);
            _loc3_++;
         }
    }

    private void _dispositionsFunc(ICustomDataInput param1) {
         IdentifiedEntityDispositionInformations _loc2_ = new IdentifiedEntityDispositionInformations();
         _loc2_.deserialize(param1);
         this.dispositions.push(_loc2_);
    }

}