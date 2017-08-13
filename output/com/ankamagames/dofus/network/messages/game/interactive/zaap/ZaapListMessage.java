package com.ankamagames.dofus.network.messages.game.interactive.zaap;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ZaapListMessage extends TeleportDestinationsListMessage implements INetworkMessage {

    private int protocolId = 1604;
    private boolean _isInitialized = false;
    private int spawnMapId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_TeleportDestinationsListMessage(param1);
         if(this.spawnMapId < 0)
         {
            throw new Exception("Forbidden value (" + this.spawnMapId + ") on element spawnMapId.");
         }
         param1.writeInt(this.spawnMapId);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc10_ = 0;
         int _loc11_ = 0;
         int _loc12_ = 0;
         int _loc13_ = 0;
         this.teleporterType = param1.readByte();
         if(this.teleporterType < 0)
         {
            throw new Exception("Forbidden value (" + this.teleporterType + ") on element of TeleportDestinationsListMessage.teleporterType.");
         }
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
         this.spawnMapId = param1.readInt();
         if(this.spawnMapId < 0)
         {
            throw new Exception("Forbidden value (" + this.spawnMapId + ") on element of ZaapListMessage.spawnMapId.");
         }
    }

}