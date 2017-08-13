package com.ankamagames.dofus.network.messages.game.interactive.zaap;

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
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TeleportDestinationsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5960;
    private boolean _isInitialized = false;
    private int teleporterType = 0;
    private Vector<uint> mapIds;
    private Vector<uint> subAreaIds;
    private Vector<uint> costs;
    private Vector<uint> destTeleporterType;
    private FuncTree _mapIdstree;
    private FuncTree _subAreaIdstree;
    private FuncTree _coststree;
    private FuncTree _destTeleporterTypetree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5960;
    }

    public TeleportDestinationsListMessage initTeleportDestinationsListMessage(int param1,Vector<uint>  param2,Vector<uint>  param3,Vector<uint>  param4,Vector<uint>  param5) {
         this.teleporterType = param1;
         this.mapIds = param2;
         this.subAreaIds = param3;
         this.costs = param4;
         this.destTeleporterType = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.teleporterType = 0;
         this.mapIds = new Vector.<uint>();
         this.subAreaIds = new Vector.<uint>();
         this.costs = new Vector.<uint>();
         this.destTeleporterType = new Vector.<uint>();
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
         this.serializeAs_TeleportDestinationsListMessage(param1);
    }

    public void serializeAs_TeleportDestinationsListMessage(ICustomDataOutput param1) {
         param1.writeByte(this.teleporterType);
         param1.writeShort(this.mapIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.mapIds.length)
         {
            if(this.mapIds[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.mapIds[_loc2_] + ") on element 2 (starting at 1) of mapIds.");
            }
            param1.writeInt(this.mapIds[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.subAreaIds.length);
         int _loc3_ = 0;
         while(_loc3_ < this.subAreaIds.length)
         {
            if(this.subAreaIds[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.subAreaIds[_loc3_] + ") on element 3 (starting at 1) of subAreaIds.");
            }
            param1.writeVarShort(this.subAreaIds[_loc3_]);
            _loc3_++;
         }
         param1.writeShort(this.costs.length);
         int _loc4_ = 0;
         while(_loc4_ < this.costs.length)
         {
            if(this.costs[_loc4_] < 0)
            {
               throw new Exception("Forbidden value (" + this.costs[_loc4_] + ") on element 4 (starting at 1) of costs.");
            }
            param1.writeVarShort(this.costs[_loc4_]);
            _loc4_++;
         }
         param1.writeShort(this.destTeleporterType.length);
         int _loc5_ = 0;
         while(_loc5_ < this.destTeleporterType.length)
         {
            param1.writeByte(this.destTeleporterType[_loc5_]);
            _loc5_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TeleportDestinationsListMessage(param1);
    }

    public void deserializeAs_TeleportDestinationsListMessage(ICustomDataInput param1) {
         int _loc10_ = 0;
         int _loc11_ = 0;
         int _loc12_ = 0;
         int _loc13_ = 0;
         this._teleporterTypeFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc10_ = param1.readInt();
            if(_loc10_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc10_ + ") on elements of mapIds.");
            }
            this.mapIds.push(_loc10_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc11_ = param1.readVarUhShort();
            if(_loc11_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc11_ + ") on elements of subAreaIds.");
            }
            this.subAreaIds.push(_loc11_);
            _loc5_++;
         }
         int _loc6_ = param1.readUnsignedShort();
         int _loc7_ = 0;
         while(_loc7_ < _loc6_)
         {
            _loc12_ = param1.readVarUhShort();
            if(_loc12_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc12_ + ") on elements of costs.");
            }
            this.costs.push(_loc12_);
            _loc7_++;
         }
         int _loc8_ = param1.readUnsignedShort();
         int _loc9_ = 0;
         while(_loc9_ < _loc8_)
         {
            _loc13_ = param1.readByte();
            if(_loc13_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc13_ + ") on elements of destTeleporterType.");
            }
            this.destTeleporterType.push(_loc13_);
            _loc9_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TeleportDestinationsListMessage(param1);
    }

    public void deserializeAsyncAs_TeleportDestinationsListMessage(FuncTree param1) {
         param1.addChild(this._teleporterTypeFunc);
         this._mapIdstree = param1.addChild(this._mapIdstreeFunc);
         this._subAreaIdstree = param1.addChild(this._subAreaIdstreeFunc);
         this._coststree = param1.addChild(this._coststreeFunc);
         this._destTeleporterTypetree = param1.addChild(this._destTeleporterTypetreeFunc);
    }

    private void _teleporterTypeFunc(ICustomDataInput param1) {
         this.teleporterType = param1.readByte();
         if(this.teleporterType < 0)
         {
            throw new Exception("Forbidden value (" + this.teleporterType + ") on element of TeleportDestinationsListMessage.teleporterType.");
         }
    }

    private void _mapIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._mapIdstree.addChild(this._mapIdsFunc);
            _loc3_++;
         }
    }

    private void _mapIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of mapIds.");
         }
         this.mapIds.push(_loc2_);
    }

    private void _subAreaIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._subAreaIdstree.addChild(this._subAreaIdsFunc);
            _loc3_++;
         }
    }

    private void _subAreaIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of subAreaIds.");
         }
         this.subAreaIds.push(_loc2_);
    }

    private void _coststreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._coststree.addChild(this._costsFunc);
            _loc3_++;
         }
    }

    private void _costsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of costs.");
         }
         this.costs.push(_loc2_);
    }

    private void _destTeleporterTypetreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._destTeleporterTypetree.addChild(this._destTeleporterTypeFunc);
            _loc3_++;
         }
    }

    private void _destTeleporterTypeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of destTeleporterType.");
         }
         this.destTeleporterType.push(_loc2_);
    }

}