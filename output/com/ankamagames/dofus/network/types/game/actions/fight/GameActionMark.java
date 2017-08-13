package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionMark extends Object implements INetworkType {

    private int protocolId = 351;
    private Number markAuthorId = 0;
    private int markTeamId = 2;
    private int markSpellId = 0;
    private int markSpellLevel = 0;
    private int markId = 0;
    private int markType = 0;
    private int markimpactCell = 0;
    private GameActionMarkedCell[] cells;
    private boolean active = false;
    private FuncTree _cellstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.markAuthorId < -9.007199254740992E15 || this.markAuthorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.markAuthorId + ") on element markAuthorId.");
         }
         param1.writeDouble(this.markAuthorId);
         param1.writeByte(this.markTeamId);
         if(this.markSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.markSpellId + ") on element markSpellId.");
         }
         param1.writeInt(this.markSpellId);
         if(this.markSpellLevel < 1 || this.markSpellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.markSpellLevel + ") on element markSpellLevel.");
         }
         param1.writeShort(this.markSpellLevel);
         param1.writeShort(this.markId);
         param1.writeByte(this.markType);
         if(this.markimpactCell < -1 || this.markimpactCell > 559)
         {
            throw new Exception("Forbidden value (" + this.markimpactCell + ") on element markimpactCell.");
         }
         param1.writeShort(this.markimpactCell);
         param1.writeShort(this.cells.length);
         int _loc2_ = 0;
         while(_loc2_ < this.cells.length)
         {
            (this.cells[_loc2_] as GameActionMarkedCell).serializeAs_GameActionMarkedCell(param1);
            _loc2_++;
         }
         param1.writeBoolean(this.active);
    }

    public void deserialize(ICustomDataInput param1) {
         GameActionMarkedCell _loc4_ = null;
         this.markAuthorId = param1.readDouble();
         if(this.markAuthorId < -9.007199254740992E15 || this.markAuthorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.markAuthorId + ") on element of GameActionMark.markAuthorId.");
         }
         this.markTeamId = param1.readByte();
         if(this.markTeamId < 0)
         {
            throw new Exception("Forbidden value (" + this.markTeamId + ") on element of GameActionMark.markTeamId.");
         }
         this.markSpellId = param1.readInt();
         if(this.markSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.markSpellId + ") on element of GameActionMark.markSpellId.");
         }
         this.markSpellLevel = param1.readShort();
         if(this.markSpellLevel < 1 || this.markSpellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.markSpellLevel + ") on element of GameActionMark.markSpellLevel.");
         }
         this.markId = param1.readShort();
         this.markType = param1.readByte();
         this.markimpactCell = param1.readShort();
         if(this.markimpactCell < -1 || this.markimpactCell > 559)
         {
            throw new Exception("Forbidden value (" + this.markimpactCell + ") on element of GameActionMark.markimpactCell.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new GameActionMarkedCell();
            _loc4_.deserialize(param1);
            this.cells.push(_loc4_);
            _loc3_++;
         }
         this.active = param1.readBoolean();
    }

}