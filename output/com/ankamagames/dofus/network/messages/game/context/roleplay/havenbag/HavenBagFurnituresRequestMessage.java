package package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

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

public class HavenBagFurnituresRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6637;
    private boolean _isInitialized = false;
    private Vector.<uint> cellIds = ;
    private Vector.<int> funitureIds = ;
    private Vector.<uint> orientations = ;
    private FuncTree _cellIdstree = ;
    private FuncTree _funitureIdstree = ;
    private FuncTree _orientationstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc4_ = 0;
    private * _loc9_ = 0;
    private int _loc10_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc6_ = param1.readUnsignedShort();
    private int _loc7_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6637;
    }

    public HavenBagFurnituresRequestMessage initHavenBagFurnituresRequestMessage(Vector.<uint> param1,Vector.<int>  param2,Vector.<uint>  param3) {
         this.cellIds = param1;
         this.funitureIds = param2;
         this.orientations = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.cellIds = new Vector.<uint>();
         this.funitureIds = new Vector.<int>();
         this.orientations = new Vector.<uint>();
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
         this.serializeAs_HavenBagFurnituresRequestMessage(param1);
    }

    public void serializeAs_HavenBagFurnituresRequestMessage(ICustomDataOutput param1) {
         param1.writeShort(this.cellIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.cellIds.length)
            if(this.cellIds[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.cellIds[_loc2_] + ") on element 1 (starting at 1) of cellIds.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HavenBagFurnituresRequestMessage(param1);
    }

    public void deserializeAs_HavenBagFurnituresRequestMessage(ICustomDataInput param1) {
         int _loc8_ = 0;
         * _loc9_ = 0;
         int _loc10_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc8_ = param1.readVarUhShort();
            if(_loc8_ < 0)
               throw new Exception("Forbidden value (" + _loc8_ + ") on elements of cellIds.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HavenBagFurnituresRequestMessage(param1);
    }

    public void deserializeAsyncAs_HavenBagFurnituresRequestMessage(FuncTree param1) {
         this._cellIdstree = param1.addChild(this._cellIdstreeFunc);
         this._funitureIdstree = param1.addChild(this._funitureIdstreeFunc);
         this._orientationstree = param1.addChild(this._orientationstreeFunc);
    }

    private void _cellIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._cellIdstree.addChild(this._cellIdsFunc);
            _loc3_++;
    }

    private void _cellIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of cellIds.");
    }

    private void _funitureIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._funitureIdstree.addChild(this._funitureIdsFunc);
            _loc3_++;
    }

    private void _funitureIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         this.funitureIds.push(_loc2_);
    }

    private void _orientationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._orientationstree.addChild(this._orientationsFunc);
            _loc3_++;
    }

    private void _orientationsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of orientations.");
    }

}