package com.ankamagames.dofus.network.messages.game.tinsel;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TitlesAndOrnamentsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6367;
    private boolean _isInitialized = false;
    private int[] titles;
    private int[] ornaments;
    private int activeTitle = 0;
    private int activeOrnament = 0;
    private FuncTree _titlestree;
    private FuncTree _ornamentstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.titles.length);
         int _loc2_ = 0;
         while(_loc2_ < this.titles.length)
         {
            if(this.titles[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.titles[_loc2_] + ") on element 1 (starting at 1) of titles.");
            }
            param1.writeVarShort(this.titles[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.ornaments.length);
         int _loc3_ = 0;
         while(_loc3_ < this.ornaments.length)
         {
            if(this.ornaments[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.ornaments[_loc3_] + ") on element 2 (starting at 1) of ornaments.");
            }
            param1.writeVarShort(this.ornaments[_loc3_]);
            _loc3_++;
         }
         if(this.activeTitle < 0)
         {
            throw new Exception("Forbidden value (" + this.activeTitle + ") on element activeTitle.");
         }
         param1.writeVarShort(this.activeTitle);
         if(this.activeOrnament < 0)
         {
            throw new Exception("Forbidden value (" + this.activeOrnament + ") on element activeOrnament.");
         }
         param1.writeVarShort(this.activeOrnament);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of titles.");
            }
            this.titles.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhShort();
            if(_loc7_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of ornaments.");
            }
            this.ornaments.push(_loc7_);
            _loc5_++;
         }
         this.activeTitle = param1.readVarUhShort();
         if(this.activeTitle < 0)
         {
            throw new Exception("Forbidden value (" + this.activeTitle + ") on element of TitlesAndOrnamentsListMessage.activeTitle.");
         }
         this.activeOrnament = param1.readVarUhShort();
         if(this.activeOrnament < 0)
         {
            throw new Exception("Forbidden value (" + this.activeOrnament + ") on element of TitlesAndOrnamentsListMessage.activeOrnament.");
         }
    }

}