package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameContextRemoveMultipleElementsWithEventsMessage extends GameContextRemoveMultipleElementsMessage implements INetworkMessage {

    private int protocolId = 6416;
    private boolean _isInitialized = false;
    private Vector<uint> elementEventIds;
    private FuncTree _elementEventIdstree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6416;
    }

    public GameContextRemoveMultipleElementsWithEventsMessage initGameContextRemoveMultipleElementsWithEventsMessage(Vector<Number> param1,Vector<uint>  param2) {
         super.initGameContextRemoveMultipleElementsMessage(param1);
         this.elementEventIds = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.elementEventIds = new Vector.<uint>();
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
         this.serializeAs_GameContextRemoveMultipleElementsWithEventsMessage(param1);
    }

    public void serializeAs_GameContextRemoveMultipleElementsWithEventsMessage(ICustomDataOutput param1) {
         super.serializeAs_GameContextRemoveMultipleElementsMessage(param1);
         param1.writeShort(this.elementEventIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.elementEventIds.length)
         {
            if(this.elementEventIds[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.elementEventIds[_loc2_] + ") on element 1 (starting at 1) of elementEventIds.");
            }
            param1.writeByte(this.elementEventIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameContextRemoveMultipleElementsWithEventsMessage(param1);
    }

    public void deserializeAs_GameContextRemoveMultipleElementsWithEventsMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readByte();
            if(_loc4_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of elementEventIds.");
            }
            this.elementEventIds.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameContextRemoveMultipleElementsWithEventsMessage(param1);
    }

    public void deserializeAsyncAs_GameContextRemoveMultipleElementsWithEventsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._elementEventIdstree = param1.addChild(this._elementEventIdstreeFunc);
    }

    private void _elementEventIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._elementEventIdstree.addChild(this._elementEventIdsFunc);
            _loc3_++;
         }
    }

    private void _elementEventIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of elementEventIds.");
         }
         this.elementEventIds.push(_loc2_);
    }

}